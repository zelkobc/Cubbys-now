import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
// import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';
import { catchError } from 'rxjs/internal/operators/catchError';
import { of } from 'rxjs/internal/observable/of';

@Component({
  selector: 'app-loginbar',
  templateUrl: './loginbar.component.html',
  styleUrls: ['./loginbar.component.css']
})
export class LoginbarComponent implements OnInit {
  @Output() logInEvent: EventEmitter<any> = new EventEmitter();
  @Output() logOutEvent: EventEmitter<any> = new EventEmitter();
  loggedUser: User | null | undefined;
  user!: string;
  pass!: string;
  regUser!: string;
  regPass!: string;
  registration: boolean = false;
  registered: boolean = true;
  isPassword: string = 'password';

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    let alreadyLogged = window.sessionStorage.user;
    if(alreadyLogged){
      alreadyLogged = JSON.parse(alreadyLogged);
    }
    if (alreadyLogged) {
      this.user = alreadyLogged.username;
      this.pass = alreadyLogged.password;
      this.regUser = '';
      this.regPass = '';
      this.logIn();
    } else {
      this.user = '';
      this.pass = '';
      this.regUser = '';
      this.regPass = '';
    }
  }

  logIn() {
    //let invitedPerson: Person | null = await this.personServ.getUserByUsername(this.invitedUsername).pipe(catchError(err => {console.log(err); return of(null)})).toPromise();
    console.log(this.user + ' ' + this.pass);
    if (this.user && this.pass) {
      this.userService.loginUser(this.user, this.pass).pipe(catchError(err => {console.log(err); return of(null)})).subscribe(
        resp => {
          if(resp != null)
          {
            this.loggedUser = resp;
            window.sessionStorage.user = JSON.stringify(this.loggedUser);
            this.logInEvent.emit();
          }
          else{
            alert("Invalid Credentials! Please try again!");
          }
        }
      );
    }
  }

  logOut() {
    this.userService.logoutUser().subscribe(
      resp => {
        this.loggedUser = null;
        this.user = '';
        this.pass = '';

        window.sessionStorage.user = JSON.stringify(this.loggedUser);
        this.logOutEvent.emit();
        window.location.reload();
      }
    );
  }

  togglePassword() {
    if (this.isPassword === 'password') {
      this.isPassword = 'text';
    } else {
      this.isPassword = 'password';
    }
  }

}
