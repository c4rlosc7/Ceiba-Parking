import { Injectable } from '@angular/core';
import { VEHICLE_LIST } from './vehicleList.json';
import { Vehicle } from './vehicle';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private urlEndPoint: string = 'http://localhost:8080/api';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getVehicleList(): Observable<Vehicle[]> {
    //return VEHICLE_LIST;
    return this.http.get(this.urlEndPoint + "/vehicles").pipe(
      map((response) => response as Vehicle[])
    );
  }

  createVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.http.post<Vehicle>(this.urlEndPoint + "/add", JSON.stringify(vehicle), { headers: this.httpHeaders });
  }

}
