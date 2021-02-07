import { User } from "./user";

export class Message {
    id: Number;
    content: String;
    writer: User;
    receiver: User;
    message_date: Date;

    constructor() {
    this.id = 0;
    this.content = '';
    this.writer = new User() ;
    this.receiver = new User() ;
    this.message_date = new Date();
    }
}