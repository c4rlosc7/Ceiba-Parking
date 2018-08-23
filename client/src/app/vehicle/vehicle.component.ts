import { Component, OnInit } from '@angular/core';
import { Vehicle } from './vehicle';
import { VehicleService } from './vehicle.service';
import { TypesVehicle } from './types-vehicle';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  vehicleList: Vehicle[];

  lengthVehicules: number;

  private vehicleModel: Vehicle = new Vehicle();

  tipos: TypesVehicle[] = [
    { id: 1, description: 'Carro' },
    { id: 2, description: 'Moto' }
  ];

  constructor(private vehicleService: VehicleService) { }

  ngOnInit() {
    this.vehicleService.getVehicleList().subscribe(
      (vehicles) => {
        this.vehicleList = vehicles;
      }
    );
  }
  
  /*console.log(this.vehicles)
  this.lengthVehicules = this.vehicles.length;*/

  /*$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
  })*/

  public createdVehicleRegister(): void{
    console.log(this.vehicleModel)
    this.vehicleService.createVehicle(this.vehicleModel).subscribe();
    this.vehicleList.push(this.vehicleModel)
  }

}
