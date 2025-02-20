import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent {
  @Input() product: any = {}; // Получаем товар от ProductListComponent
  @Output() remove = new EventEmitter<number>(); // Событие удаления товара
  likes: number = 0; // Новый счётчик лайков

  likeProduct() {
    this.likes++; // Увеличиваем количество лайков
  }

  share(productLink: string) {
    const text = `Посмотри этот товар: ${productLink}`;
    const telegramUrl = `https://t.me/share/url?url=${encodeURIComponent(text)}`;
    window.open(telegramUrl, '_blank');
  }

  openWhatsApp() {
    const url = 'https://web.whatsapp.com/';
    window.open(url, '_blank');
  }

  deleteProduct() {
    this.remove.emit(this.product.id); // Отправляем id товара родителю
  }
}
