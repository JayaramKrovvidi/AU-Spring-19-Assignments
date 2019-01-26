import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/Providers/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  book:any;
  id : number;

  constructor(private bookservice:BookService) { }

  ngOnInit() {
  
  }

  searchBook(){
    this.bookservice.getBook(this.id).subscribe((response)=>{
      console.log(response);
        this.book=response;
    });
  }
}
