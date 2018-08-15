import { Injectable } from '@angular/core';
import { VEHICLE_LIST } from './vehicleList.json';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor() { }

  getVehicleList(): Vehicle[] {
    return VEHICLE_LIST;
  }
}
