import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, of, shareReplay, tap, throwError } from 'rxjs';
import { User } from '../../domain/model/user.model';
import { UserDto } from '../dto/user.dto';
import { LoginResponse } from '../dto/loginResponse.dto';
import { UserMapper } from '../../domain/mappers/user.mapper';
import { config } from '../config/config';
import moment from "moment";
import { CookieService } from 'ngx-cookie-service';
import { UserService } from './user.service';
import { RoleService } from './role.service';
import { Role } from '../../domain/model/role.model';

class UserLogin {
  email!: string;
  password!: string | null;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {


  isLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUser: BehaviorSubject<String | null> = new BehaviorSubject<String | null>(null);
  token!:string;
  isAuthenticatedRoled:boolean=false;


  constructor(private http: HttpClient,private cookieService: CookieService,private userServie:UserService,private roleService:RoleService) {
    this.token = this.cookieService.get('token');
    this.isLoggedIn = new BehaviorSubject<boolean>(this.token ? true : false);
    this.currentUser = new BehaviorSubject<String | null>(this.token || null);
  }
  ngOnInit(){
    console.log(`ngOnInit  - data is ${this.token}`);
  }
  login(user: User) {
    const raw = new UserLogin(); // Create a new UserLogin object
    raw.email = user.email;
    raw.password = user.password;
    return this.http.post<LoginResponse>(`${config['authUrl']}/login`, JSON.stringify(raw)).pipe(
      tap((response: LoginResponse) => {
        const expiresAt = moment().add(response.expiresIn, 'milliseconds').toDate();
        this.cookieService.set('token', response.token, expiresAt);
        this.currentUser.next(response.token);
        this.isLoggedIn.next(true);
      }),
      map((response) => response.token),
      catchError(this.handleError)
    );
  }


  register(user: User): Observable<User> {
    const userDto = UserMapper.toDto(user);
    return this.http
      .post<UserDto>(`${config['authUrl']}/signup`, JSON.stringify(userDto))
      .pipe(map(UserMapper.toDomain));
  }

  isAuthenticated(){
    return this.userServie.getUser;
  }

  hasRole(roles: string[]): Observable<boolean> {
    return new Observable<boolean>(observer => {
      this.roleService.getRolesByUser().subscribe({
        next: (rolesByUser: Role[]) => {
          // Check if any of the user's roles match the required roles
          const hasRole = roles.some(requiredRole => rolesByUser.some(roleByUser => roleByUser.name === requiredRole));

          observer.next(hasRole);
          observer.complete();
        },
        error: (error) => {

          observer.next(false);
          observer.complete();
        },
      });
    });
  }
  logout(): void {
    // Clear the token cookie
    this.cookieService.delete('token');
    this.isLoggedIn.next(false);
    this.currentUser.next('');
  }


  get user(): Observable<String | null> {
    return this.currentUser.asObservable();
  }

  get userIsLoggedIn(): Observable<boolean> {
    return this.isLoggedIn.asObservable();
  }

  get userToken(): String | null {
    return this.currentUser.value;
  }
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('Se ha producio un error ', error.error);
    }
    else {
      console.error('Backend retornó el código de estado ', error);
    }
    return throwError(() => new Error('Algo falló. Por favor intente nuevamente.'));
  }
}




