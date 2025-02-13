import { Component } from '@angular/core'; 
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-products',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  products = [
    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/hef/h6e/86640643702814.png?format=gallery-medium' ,
      name : 'Celimax тонер Dual Barrier 150 мл',
      description : 'Барьерный кремовый тонер Celimax Dual Barrier Creamy Toner увлажняет, питает и восстанавливает' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/celimax-toner-dual-barrier-150-ml-108098827/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/pea/pe8/13746243.jpeg?format=gallery-medium' ,
      name : 'CeraVe Увлажняющий крем для сухой и очень сухой кожи лица и тела, 50 мл',
      description : 'CeraVe Увлажняющий кремэта насыщенная, но нежирная формула, обеспечивающая длительное увлажнение ' ,
      rating : 4.9 , 
      link : 'https://kaspi.kz/shop/p/cerave-uvlazhnjajuschii-krem-dlja-suhoi-i-ochen-suhoi-kozhi-litsa-i-tela-50-ml-100757355/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/pc7/pf8/3164243.png?format=gallery-medium' ,
      name : 'Bioderma Sensibio H2O мицеллярная вода 500 мл',
      description : 'Мицеллярная вода Bioderma Sensibio H2O предназначена для мягкого удаления макияжа и загрязнений с чувствительной кожи' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/bioderma-sensibio-h2o-mitselljarnaja-voda-500-ml-21900212/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/p29/p94/16687695.jpg?format=gallery-medium' ,
      name : 'LANEIGE маска Lip Sleeping Mask Ex Berry 3 г',
      description : 'Ночная восстанавливающая маска для губ Laneige Lip Sleeping Mask (Berry)' ,
      rating : 4.9 , 
      link : 'https://kaspi.kz/shop/p/laneige-maska-lip-sleeping-mask-ex-berry-3-g-104726768/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/hb1/h52/87135249694750.jpg?format=gallery-medium' ,
      name : 'EVO Laboratoires Пантенол крем 46 мл',
      description : 'Оптимальное содержание Декспантенола в размере 5% обеспечивает эффективный уход за раздраженной, сухой и склонной к шелушению кожей.' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/evo-laboratoires-pantenol-krem-46-ml-101072759/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/h49/h18/63917558333470.jpg?format=gallery-medium' ,
      name : 'Elemis крем Pro-Collagen Marine Anti-Wrinkle SPF30 для лица 50 мл',
      description : 'Крем для лица Pro-Collagen выступает в роли антиэйдж терапии, а также как средство профилактики фотостарения' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/elemis-krem-pro-collagen-marine-anti-wrinkle-spf30-dlja-litsa-50-ml-100998931/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/ha1/hae/86610452742174.jpg?format=gallery-medium' ,
      name : 'DAlba сыворотка First Spray Serum для лица 100 мл',
      description : 'Мультифункциональная спрей сыворотка увлажняет, питает и наполняет энергией тусклую и усталую кожу.' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/d-alba-syvorotka-first-spray-serum-dlja-litsa-100-ml-109604708/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/p3f/pfa/18657801.jpg?format=gallery-medium' ,
      name : 'Clinique гель Dramatically Different Moisturizing для лица 125 мл',
      description : 'Увлажняющая база, для использования вместе с активным концентратом в составе системы Clinique iD' ,
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/clinique-gel-dramatically-different-moisturizing-dlja-litsa-125-ml-115781416/?c=750000000'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/p5e/p94/24046488.jpg?format=gallery-medium' ,
      name : 'Avene крем XeraCalm A.D Липидовосстанавливающий для лица, для зоны декольте 200 мл',
      description : 'Липидовосстанавливающий крем XeraCalm A.D облегчает состояние очень сухой кожи, склонной к атопическому дерматиту и зуду',
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/avene-krem-xeracalm-a-d-lipidovosstanavlivajuschii-dlja-litsa-dlja-zony-dekol-te-200-ml-101889257/?c=750000000&utm_source=google&utm_medium=cpc&utm_campaign=shop_google_performance_max_clothes&gbraid=0AAAAAC7-v7g7UFTPzl9UecJXI-fp-s5CP&gclid=CjwKCAiAqrG9BhAVEiwAaPu5zgIoKJkyAczVt2QnzKL_dAwURrT5_lKdZ1GHne8-VPSIb7bAkphzoxoCO4QQAvD_BwE'
    },

    {
      image : 'https://resources.cdn-kaspi.kz/img/m/p/hc0/hd8/85532623044638.jpg?format=gallery-medium' ,
      name : 'ANGIOPHARM сыворотка Anti-Couperose для лица 30 мл',
      description : 'обладает легкой текстурой и быстро впитывается, не оставляя дискомфорта.',
      rating : 5.0 , 
      link : 'https://kaspi.kz/shop/p/angiopharm-syvorotka-anti-couperose-dlja-litsa-30-ml-117770050/?c=750000000&utm_source=google&utm_medium=cpc&utm_campaign=shop_google_performance_max_clothes&gbraid=0AAAAAC7-v7g7UFTPzl9UecJXI-fp-s5CP&gclid=CjwKCAiAqrG9BhAVEiwAaPu5zgIoKJkyAczVt2QnzKL_dAwURrT5_lKdZ1GHne8-VPSIb7bAkphzoxoCO4QQAvD_BwE'
    }

    
  ];

  share(productLink : string ){

    const text = `Посмотри этот товар: ${productLink}`;

    const telegramUrl = `https://t.me/share/url?url=${encodeURIComponent(text)}`

    window.open(telegramUrl, '_blank')
    
  }

}
