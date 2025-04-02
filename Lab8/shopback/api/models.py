"""
по заданию нужно создать два модуля для Категории и Продукта
__str__ нужно для того чтобы при выводе категории в интерфейсе показывалось только название 
category = переменная для того чтобы была связь между категорий и продуктами

ForeignKey - связь "один ко многим"

"""
from django.db import models

class Category(models.Model):
    name = models.CharField(max_length=150)

    def __str__(self):
        return self.name

class Product(models.Model):
    name = models.CharField(max_length=255)
    price = models.FloatField()
    description = models.TextField()
    count = models.IntegerField()
    is_active = models.BooleanField(default = True)

    category = models.ForeignKey(Category , related_name='products' , on_delete=models.CASCADE)

    def __str__(self):
        return self.name
