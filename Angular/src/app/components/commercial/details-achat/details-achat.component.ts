import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CommercialService} from '../../../services/commercial.service';
import {CommandeApprovisionnement} from '../../../model/modele.commandeApprovisionnement';
import {DetailsApprovisionnement} from '../../../model/modele.detailsApprovisionnement';
import { NgFlashMessageService } from 'ng-flash-messages';

@Component({
  selector: 'app-details-achat',
  templateUrl: './details-achat.component.html',
  styleUrls: ['./details-achat.component.css']
})
export class DetailsAchatComponent implements OnInit {
  idAchat: number;
  pageDetailsAchats: Array<any>;
  commandeApp: CommandeApprovisionnement = new CommandeApprovisionnement();
  produits: any;
  detailsApp: DetailsApprovisionnement = new DetailsApprovisionnement();
  commandeId: number;
  constructor(public activatedRoute: ActivatedRoute,
              public commercialService: CommercialService,
              public router: Router,
              public flashMessage: NgFlashMessageService) {
              this.idAchat = activatedRoute.snapshot.params['id'];
  }
  ngOnInit() {
    this.commercialService.getAchat(this.idAchat)
      .subscribe(data => {
        this.commandeApp = data;
      }, err => {
        console.log(err);
      });
    this.commercialService.getProduits()
      .subscribe(produits => {
        this.produits = produits;
      }, err => {
        console.log(err);
      });
    this.commercialService.getDetailsApp(this.idAchat)
      .subscribe(dt => {
        this.pageDetailsAchats = dt;
      }, err => {
        console.log(err);
      });
  }
  onEditAchat(id: number) {
    this.router.navigate(['edit-achat', id]);
  }
  onDeleteAchat(c: CommandeApprovisionnement) {
    const confirm = window.confirm('Etes-vous sûr ?');
    if (confirm === true) {
      this.commercialService.deleteAchat(c.idApprovisionnement)
        .subscribe(data => {
          this.router.navigate(['/achats']);
        }, err => {
          console.log(err);
        });
    }
  }
  addDetails() {
    this.detailsApp.commandeId = this.commandeApp.idApprovisionnement;
    this.commercialService.addDetailsAchat(this.detailsApp)
      .subscribe(data => {
        this.commercialService.getDetailsApp(this.idAchat)
          .subscribe(dt => {
            this.pageDetailsAchats = dt;
          }, err => {
            console.log(err);
          });
        this.flashMessage.showFlashMessage({
          messages: ['Félicitations, les détails ont été ajoutés avec succées'],
          dismissible: true,
          timeout: 2000,
          type: 'success'
        });
      }, err => {
        console.log(err);
      });
  }
}
