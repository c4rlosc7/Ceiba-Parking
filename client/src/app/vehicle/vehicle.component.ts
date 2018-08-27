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
        this.getLengthCars(this.vehicleList);
        this.getLengthMotos(this.vehicleList);
      }
    );
  }

  /**
  * Abre el modal de agregar
  */
  public openModalCreate(): void {
    //debugger
    //this.vehicleModel = null;
    this.display = 'block';
  }

  /**
  * Abre el modal de actualizar
  */
  public openModalUpdate(): void {
    this.display = 'block';
  }

  /**
   * Oculta el modal de agregar
   */
  public hideModal(): void {
    //this.vehicleModel = null;
    this.display = 'none';
  }

  /**
   * Calcula el total de vehiculos registrados en el parqueadero
   * @param vehicleList 
   */
  public getLengthVehicleList(vehicleList: Vehicle[]): void {
    this.lengthVehicules = vehicleList.length;
  }

  /**
   * Calcular el total de carros ingresados en el parqueadero
   * @param vehicleList 
   */
  public getLengthCars(vehicleList: Vehicle[]): void {
    let count = 0;
    for (let index = 0; index < vehicleList.length; index++) {
      if (vehicleList[index].tipo == 1) {
        count++
      }
    }
    this.lengthCars = count
  }

  /**
   * Obtiene el total de motos ingresadas en el parqueadero
   * @param vehicleList 
   */
  public getLengthMotos(vehicleList: Vehicle[]): void {
    let count = 0;
    for (let index = 0; index < vehicleList.length; index++) {
      if (vehicleList[index].tipo == 2) {
        count++
      }
    }
    this.lengthMotos = count;
  }

  /**
   * Crea un nuevo registro de parqueadero
   */
  public createdVehicleRegister(): void {
    this.vehicleService.createVehicleRegister(this.vehicleModel).subscribe((response) => {
      console.log(response)
      this.vehicleList.push(response)
      this.hideModal();
    }, error => {
      alert(error.error.message)
    });
  }


  public initUpdate(v: Vehicle): void {
    this.vehicleModel = v;
    this.openModalUpdate();
  }

  /**
   * Gestiona si se requiere guardar o actualizar
   */
  public saveVehicleRegister(): void {
    if (this.vehicleModel.id) {
      this.updateVehicleRegister();
    } else {
      this.createdVehicleRegister();
    }
  }

  /**
   * Actualiza el registro del ingreso al parqueadero
   */
  public updateVehicleRegister(): void {
    this.vehicleService.updateVehicleRegister(this.vehicleModel, this.vehicleModel.id).subscribe((response) => {
      this.vehicleModel = response;
      this.hideModal();
    }, error => {
      alert(error.error.message)
    });
  }

  /**
   * Calcula el costo del parqueadero
   */
  public calculateFee(v: Vehicle, index: number): void {
    this.vehicleService.calculateFee(v.id).subscribe((response) => {
      this.vehicleList[index] = response;
    }, error => {
      alert(error.error.message)
    });
  }

}
