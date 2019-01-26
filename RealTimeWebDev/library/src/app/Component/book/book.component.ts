import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from 'src/app/Providers/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  book : any;
  id : any;

  constructor(private active : ActivatedRoute,private bookservice:BookService) { }

  ngOnInit() {
    this.id = this.active.snapshot.paramMap.get('id');
    this.bookservice.getBook(this.id).subscribe((response)=>{
      console.log(response);
        this.book=response;
    });
  }

}
