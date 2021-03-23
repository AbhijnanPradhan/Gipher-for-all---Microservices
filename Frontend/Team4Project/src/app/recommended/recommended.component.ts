import { Component, OnInit } from '@angular/core';
import { DataBlock } from '../interfaces/ApiDataInterface';
import { RecommendedService } from '../services/database/recommended/recommended.service';

@Component({
  selector: 'app-recommended',
  templateUrl: './recommended.component.html',
  styleUrls: ['./recommended.component.css']
})
export class RecommendedComponent implements OnInit {
  showSearchBar:boolean = false;
  showRecommendedLink:boolean = false;
  constructor(private recommendedService: RecommendedService) { }

  public dataParts: Array<DataBlock> = [];

  ngOnInit(): void {
    this.recommendedService.getBehaviourSubject()
      .subscribe(dataBlocks => {
        console.log('get recommended recommended component', dataBlocks);
        this.dataParts = dataBlocks;
        console.log('Data part', this.dataParts)
      });
    this.recommendedService.getRecommended();
  }
}
