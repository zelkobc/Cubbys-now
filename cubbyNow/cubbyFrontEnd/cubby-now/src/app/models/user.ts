import { Group } from "./group";
import { Role } from "./role";

export class User {
    id: number;
    username: string;
    password: string;
    role: Role;
    groups: Group[];

    constructor(){
      this.id = -1;
      this.username = "";
      this.password = "";
      this.role = new Role();
      this.groups = [];
    }
}
