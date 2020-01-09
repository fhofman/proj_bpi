import { Component, OnInit } from '@angular/core';
import { Price } from '../model/price';
import { PriceService } from '../service/price.service';

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.css']
})
export class PriceListComponent implements OnInit {

  price: Price;

  constructor(private priceService: PriceService) {
  }

  ngOnInit() {
    this.priceService.findAll().subscribe(data => {
      console.log(data);
      this.price = data;
    });
  }
}
