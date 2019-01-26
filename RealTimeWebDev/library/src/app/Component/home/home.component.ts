import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/Providers/book.service';
import { Book } from 'src/app/Model/book';
import { Checkout } from 'src/app/model/checkout';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  books : Book [];
  singleBook : any;
  bookId : any;
  bookName : any;
  authorName : any;
  bookPrice : any;
  bookDesc : any; 

  constructor( private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAllBooks().subscribe((response)=>
    {
      if(response && response.length > 0)
        this.books = response;
    });
  }

  postData()
  {
    const b = new Book(this.bookId, this.bookName, this.authorName, this.bookPrice, this.bookDesc);
    this.bookService.putInDb(b).subscribe((response) =>
    {
      if(response)
        console.log(response);
    });
  }

  checkOut(id : any){
    console.log(id);
    this.bookService.addcart(new Checkout(1,"name")).subscribe();
  }

}
