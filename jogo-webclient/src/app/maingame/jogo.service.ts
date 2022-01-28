import { Injectable, NgModule } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NodeModel } from './node.model';

@Injectable({
  providedIn: 'root'
})
export class JogoService {

  baseUrl: string = '/game';

  constructor(private httClient: HttpClient) { }

  getRootNode(): Observable<NodeModel>{
    return this.httClient.get<NodeModel>(this.baseUrl);
  }

  getNext(nextNodeId: number): Observable<NodeModel>{
    const url = `${this.baseUrl}/${nextNodeId}`;
    return this.httClient.get<NodeModel>(url);
  }

  createNode(node: NodeModel): Observable<NodeModel>{
    return this.httClient.post<NodeModel>(`${this.baseUrl}/new`, node);
  }

  updateNode(node: NodeModel): Observable<NodeModel>{
    return this.httClient.put<NodeModel>(`${this.baseUrl}/update`, node);
  }
}
