export class Book {
    bookId : any;
  bookName : any;
  authorName : any;
  bookPrice : any;
  bookDesc : any; 

  constructor(id,name,author,price,desc)
  {
    this.bookId = id;
    this.bookName = name;
    this.authorName = author;
    this.bookPrice = price;
    this.bookDesc = desc;
  }
}
