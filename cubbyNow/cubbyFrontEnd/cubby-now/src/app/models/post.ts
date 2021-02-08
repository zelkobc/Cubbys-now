export class Post {
    postid: number;
    authorid: number;
    content: string;
    groupid: number;

    constructor()
    {
        this.postid = -1;
        this.authorid = -1;
        this.content = "";
        this.groupid = null;
    }
}
