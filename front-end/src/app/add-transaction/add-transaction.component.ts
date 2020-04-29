import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from '../transaction-service.service';
import { TransactionClass } from '../transaction-class';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  constructor( private refOfTransactionService:TransactionServiceService ) { }

  objOfTranaction:TransactionClass=new TransactionClass();

  ngOnInit(): void {
  }

  addTransaction():void
  {
  this.refOfTransactionService.createNewTransaction(this.objOfTranaction).subscribe(data=>
  {
    alert("Transaction Done");
  },
  error=>
  {
    console.log("erroor occured",error);
  }
);
  }
}
