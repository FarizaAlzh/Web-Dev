import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AlbumsService } from '../albums.service';
import { Album } from '../models';

@Component({
  selector: 'app-albums',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule], 
  providers: [AlbumsService],  
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent implements OnInit {
  albums: Album[] = [];
  newAlbum: Album = { id: 0, title: '', userId: 1 }; 
  loaded: boolean = false;

  constructor(private albumService: AlbumsService) {}

  ngOnInit(): void {
    this.getAlbums();
  }

  getAlbums(): void {
    this.albumService.getAlbums().subscribe((data) => {
      this.albums = data;
      this.loaded = true;
    });
  }

  createAlbum(): void { 
    if (!this.newAlbum.title.trim()) {
      console.warn('Название альбома не может быть пустым!');
      return;
    }
    this.albumService.createAlbum(this.newAlbum).subscribe((album) => {
      this.albums.push(album);
      this.newAlbum = { id: 0, title: '', userId: 1 }; 
    });
  }
  

  deleteAlbum(id: number): void {
    this.albumService.deleteAlbum(id).subscribe(() => {
      this.albums = this.albums.filter((album) => album.id !== id);
    });
  }

  trackAlbum(index: number, album: Album): number {
    return album.id;
  }
}
