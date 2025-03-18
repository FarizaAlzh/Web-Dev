import { Component , OnInit} from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { AlbumsService } from '../albums.service';
import { Photo } from '../models';

@Component({
  selector: 'app-album-photos',
  standalone: true,
  imports: [CommonModule, NgFor, RouterModule],
  templateUrl: './album-photos.component.html',
  styleUrl: './album-photos.component.css'
})
export class AlbumPhotosComponent implements OnInit {
  photos!: Photo[];

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumsService
  ) {}


  ngOnInit(): void {
    this.getPhotos();
  }
  
  getPhotos() {
    this.route.paramMap.subscribe((params) => {
      const albumId: number = Number(params.get('id'));
      this.albumService.getPhotos(albumId).subscribe((photos) => {
        this.photos = photos;
      });
    });
  }
  
}
