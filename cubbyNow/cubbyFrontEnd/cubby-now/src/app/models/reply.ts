import {Post} from "./post";
import {User} from "./user";

export class Reply {
    id: number;
    message: string;
    post: Post;
    author: User;

    constructor()
    {
        this.id = -1;
        this.message = "";
        this.post = new Post();
        this.author = new User();
    }
}
