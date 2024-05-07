export  class Role {
  id!: number;
  name!: string;

  constructor(data:Partial<Role>){
    Object.assign(this, data);
  }
}
