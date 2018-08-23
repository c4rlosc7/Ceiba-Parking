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
  display = 'none';

  lengthVehicules: number;
  lengthCars: number;
  lengthMotos: number;

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
        this.getLengthVehicleList(this.vehicleList);
      }
    );    
  }

  public getLengthVehicleList(vehicleList: Vehicle[]): void{
    this.lengthVehicules = vehicleList.length;
  }

  public getLengthCars(vehicleList: Vehicle[]): void{

  }

  public getLengthMotos(vehicleList: Vehicle[]): void{

  }

  public createdVehicleRegister(): void{
    this.vehicleService.createVehicle(this.vehicleModel).subscribe((response) => {
      this.vehicleList.push(response)
      this.hideModal();      
    }, error => {
      alert(error.error.message)
    });
  }

  public openModal(): void{
    this.display = 'block';
  }

  public hideModal(): void{
    this.display = 'none';
  }



}
