export class Permission {

  id!: number;
  name!: string;



  constructor(data:Partial<Permission>){
    Object.assign(this, data);
  }
}
