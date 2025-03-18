import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Location } from "@angular/common";
import { AlbumsService } from "../albums.service";
import { Album } from "../models";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router"; 

@Component({
  selector: "app-album-detail",
  standalone: true, 
  templateUrl: "./album-detail.component.html",
  styleUrls: ["./album-detail.component.css"],
  imports: [FormsModule, CommonModule, RouterModule]  
})
export class AlbumDetailComponent implements OnInit {
  album!: Album;
  updatedTitle: string = "";

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumsService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.loadAlbum();
  }

  loadAlbum(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    if (id) {
      this.albumService.getAlbum(id).subscribe((album) => {
        this.album = album;
        this.updatedTitle = album.title;
        console.log("Loaded album:", this.album);
      });
    }
  }

  saveAlbum(): void {
    if (!this.album) return;
  
    const updatedAlbum = { ...this.album, title: this.updatedTitle };
    
  
    this.albumService.updateAlbum(updatedAlbum).subscribe((response) => {
      this.album.title = response.title; 
    });
  }  

  goBack(): void {
    this.location.back();
  }
}
