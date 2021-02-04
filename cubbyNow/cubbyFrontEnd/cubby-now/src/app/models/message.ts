import { User } from "./user";

export class Message {
    id: Number;
    content: String;
    writer: User;
    receiver: User;
    message_date: Date;
}
