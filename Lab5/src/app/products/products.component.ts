import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from '../product-list/product-list.component';  // Импортируем ProductListComponent

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, ProductListComponent],  // Добавляем ProductListComponent в imports
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  categories = [
    {
      name : 'Beauty and health',
      products : [
        {
          id : 1, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/hef/h6e/86640643702814.png?format=gallery-medium' ,
          name : 'Celimax тонер Dual Barrier 150 мл',
          description : 'Барьерный кремовый тонер Celimax Dual Barrier Creamy Toner увлажняет, питает и восстанавливает' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/celimax-toner-dual-barrier-150-ml-108098827/?c=750000000'
        },
    
        {
          id : 2,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/pea/pe8/13746243.jpeg?format=gallery-medium' ,
          name : 'CeraVe Увлажняющий крем для сухой и очень сухой кожи лица и тела, 50 мл',
          description : 'CeraVe Увлажняющий кремэта насыщенная, но нежирная формула, обеспечивающая длительное увлажнение ' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/cerave-uvlazhnjajuschii-krem-dlja-suhoi-i-ochen-suhoi-kozhi-litsa-i-tela-50-ml-100757355/?c=750000000'
        },
    
        {
          id : 3, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/pc7/pf8/3164243.png?format=gallery-medium' ,
          name : 'Bioderma Sensibio H2O мицеллярная вода 500 мл',
          description : 'Мицеллярная вода Bioderma Sensibio H2O предназначена для мягкого удаления макияжа и загрязнений с чувствительной кожи' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/bioderma-sensibio-h2o-mitselljarnaja-voda-500-ml-21900212/?c=750000000'
        },
    
        {
          id : 4, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/p29/p94/16687695.jpg?format=gallery-medium' ,
          name : 'LANEIGE маска Lip Sleeping Mask Ex Berry 3 г',
          description : 'Ночная восстанавливающая маска для губ Laneige Lip Sleeping Mask (Berry)' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/laneige-maska-lip-sleeping-mask-ex-berry-3-g-104726768/?c=750000000'
        },
    
        {
          id : 5,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/hb1/h52/87135249694750.jpg?format=gallery-medium' ,
          name : 'EVO Laboratoires Пантенол крем 46 мл',
          description : 'Оптимальное содержание Декспантенола в размере 5% обеспечивает эффективный уход за раздраженной, сухой и склонной к шелушению кожей.' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/evo-laboratoires-pantenol-krem-46-ml-101072759/?c=750000000'
        }
      ]
    },

    {
      name : 'Clothing',
      products : [
        {
          id : 6, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h02/h76/85858104803358.jpg?format=gallery-medium' ,
          name : 'Рубашка A BLVD мультиколор',
          description : 'Рубашка в клетку оверсайз на кнопках.' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/rubashka-a-blvd-5567568-mul-tikolor-l-118806366/?c=750000000&hasVariants=true'
        },
    
        {
          id : 7,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/hbd/h93/83857662935070.jpg?format=gallery-medium' ,
          name : 'Носки 916721 1 пара белый 35-41',
          description : 'Носки с ручками на магните и принтом глазами влюбленных пар' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/noski-916721-1-para-belyi-35-41-113384332/?c=750000000'
        },
    
        {
          id : 8,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/p02/p4e/6019639.jpeg?format=gallery-medium' ,
          name : 'Свитшот LIMIKO черный, мультиколор',
          description : 'Свитшот женский без начеса - это базовая одежда любой женщины или девушки.' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/svitshot-limiko-swt-n003-mk-mul-tikolor-chernyi-2xl-129322033/?c=750000000'
        },
    
        {
          id : 9,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/p91/pa1/6755827.jpeg?format=gallery-medium' ,
          name : 'Свитшот Kimiko Shop бордовый',
          description : 'Свитшот Kimiko Shop бордовый,свободного кроя, круглогодичный' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/svitshot-kimiko-shop-67843-bordovyi-m-128677195/?c=750000000'
        },
    
        {
          id : 10,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/hbc/h9a/85756876029982.jpg?format=gallery-medium' ,
          name : 'Джинсы широкие и расклешенные Fashion серый',
          description : 'Джинсы широкие Fashion серый ,широкие и расклешенные, посадка высокая' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/dzhinsy-shirokie-i-raskleshennye-fashion-445700-seryi-w33-118455614/?c=750000000'
        }

      ]
    },

    {
      name : 'Electronics',
      products : [
        {
          id : 11, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h32/h70/84378448199710.jpg?format=gallery-medium' ,
          name : 'Смартфон Apple iPhone 13 128Gb черный',
          description : 'Apple iPhone 13 получил дисплей 6.1 дюйма Super Retina XDR' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/apple-iphone-13-128gb-chernyi-102298404/?c=750000000'
        },
    
        {
          id : 12,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h5c/hec/86261115060254.png?format=gallery-medium' ,
          name : 'Чехол Для Apple iPhone 13 прозрачный',
          description : 'Надежный и стильный чехол для вашего смартфона' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/dlja-apple-iphone-13-prozrachnyi-106185651/?c=750000000'
        },
    
        {
          id : 13,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h41/h98/87295491702814.png?format=gallery-medium' ,
          name : 'Смартфон Apple iPhone 16 Pro Max 256Gb золотистый',
          description : 'Флагманский IPhone 16 Pro Max вобрал в себя лучшие черты современного гаджета' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/apple-iphone-16-pro-max-256gb-zolotistyi-123890547/?c=750000000'
        },
    
        {
          id : 14,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h1b/h77/84526902706206.jpg?format=gallery-medium' ,
          name : 'Смартфон Xiaomi Redmi 13C 8 ГБ/256 ГБ черный',
          description : '4G (LTE)Да Стандарт4G' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/xiaomi-redmi-13c-8-gb-256-gb-chernyi-114695323/?c=750000000'
        },
    
        {
          id : 15,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h5f/h9e/86261130854430.jpg?format=gallery-medium' ,
          name : 'Чехол Для Apple iPhone 11 прозрачный',
          description : 'Надежный и стильный чехол для вашего смартфона, обеспечивающий защиту от царапин' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/samsung-galaxy-a16-6-gb-128-gb-chernyi-130609900/?c=750000000'
        }

      ]
    }, 
    {
      name : 'Furniture',
      products : [
        {
          id : 16, 
          image : 'https://resources.cdn-kaspi.kz/img/m/p/p3c/p0e/1618343.png?format=gallery-medium' ,
          name : 'Morbido диван прямой Комфорт, обивка микровелюр',
          description : 'Практичный  диван-кровать с легкой системой трансформации' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/morbido-divan-prjamoi-komfort-obivka-mikroveljur-80h210h80-sm-bezhevyi-109383093/?c=750000000'
        },
    
        {
          id : 17,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/ha9/h0d/64346355367966.jpg?format=gallery-medium' ,
          name : 'Вешалка напольная Double Pole Cas',
          description : 'Представляем вашему вниманию прочную и удобную вешалку, изготовленную из стали' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/veshalka-napol-naja-double-pole-cas-106834497-metall-110x150-sm-chernyi-106834497/?c=750000000'
        },
    
        {
          id : 18,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h17/h2b/86703072149534.png?format=gallery-medium' ,
          name : 'Игровое кресло 501126, черный',
          description : 'Упругий наполнитель гарантирует устойчивость посадки, а экокожа – прочность и износостойкость' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/igrovoe-kreslo-501126-chernyi-111098602/?c=750000000'
        },
    
        {
          id : 19,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/ha2/h45/86503356858398.jpg?format=gallery-medium' ,
          name : 'Распашной шкаф Qazyna Jihaz 8045190',
          description : 'Характеристики Распашной шкаф Qazyna Jihaz 8045190, 80x190х45 см' ,
          rating : 4.9 , 
          link : 'https://kaspi.kz/shop/p/raspashnoi-shkaf-qazyna-jihaz-8045190-80x190h45-sm-belyi-korichnevyi-108794828/?c=750000000'
        },
    
        {
          id : 20,
          image : 'https://resources.cdn-kaspi.kz/img/m/p/h94/h42/86777028378654.png?format=gallery-medium' ,
          name : 'Диван прямой Комфорт, обивка велюр, 85х210х80 см',
          description : 'Раскладной и удобный диван в современном зеленом цвете идеально подойдет в любой интерьер' ,
          rating : 5.0 , 
          link : 'https://kaspi.kz/shop/p/divan-prjamoi-komfort-obivka-veljur-85h210h80-sm-zelenyi-108396588/?c=750000000'
        }

      ]
    }


  ];

  selectedCategory: any = null;

  selectCategory(category: any) {
    this.selectedCategory = category;
  }

  share(productLink : string ){
    const text = `Посмотри этот товар: ${productLink}`;
    const telegramUrl = `https://t.me/share/url?url=${encodeURIComponent(text)}`
    window.open(telegramUrl, '_blank')
  }

  openWhatsApp() {
    const url = 'https://web.whatsapp.com/'
    window.open(url, '_blank');
  }
}
