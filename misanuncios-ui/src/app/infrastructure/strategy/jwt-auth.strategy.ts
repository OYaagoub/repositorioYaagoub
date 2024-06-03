import { Observable, of } from "rxjs";
import { Token } from "../../domain/model/token.model";
import { User } from "../../domain/model/user.model";


export class JwtAuthStrategy {
  private readonly JWT_TOKEN = "JWT_TOKEN";

  doLoginUser(token: Token): void {
    localStorage.setItem(this.JWT_TOKEN, token.jwt);
  }

  doLogoutUser(): void {
    localStorage.removeItem(this.JWT_TOKEN);
  }

  getCurrentUser(): Observable<any> {
    const token = this.getToken();
    if (token) {
      const encodedPayload = token.split(".")[1];
      const payload = window.atob(encodedPayload);
      return of(JSON.parse(payload));
    } else {
      return of(undefined);
    }
  }

  getToken() {
    return localStorage.getItem(this.JWT_TOKEN);
  }
}
