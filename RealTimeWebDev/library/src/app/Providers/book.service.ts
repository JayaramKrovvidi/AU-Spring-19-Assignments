import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<any>
  {
    return this.http.get('/arvSpring/books');

  }

  getBook(id : any): Observable<any>
  {
    return this.http.get('/arvSpring/books/get/'+id);
  }

  putInDb(b): Observable<any>
  {
    return this.http.post('/arvSpring/books/post',b);
  }

  addcart(id : any):Observable<any>{
    return this.http.post("/arvSpring/addcart/",id);
  }

  getCheckoutList(): Observable<any>{
    return this.http.get("/arvSpring/getcart");
  }
}
