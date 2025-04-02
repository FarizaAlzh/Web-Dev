from django.shortcuts import render

# Create your views here.
"""
нужно создать вьюшки для АПИ
safe=False — можно отправлять любые данные, включая списки.
"""
from django.http import JsonResponse
from .models import Product , Category

def product_list(request):
    products = Product.objects.all()
    data = list(products.values('id' , 'name' , 'price' , 'description' , 'count' , 'is_active' , 'category__name'))
    return JsonResponse(data , safe=False)


def product_one(request , id):
    try:
        product = Product.objects.get(id=id)
    except Product.DoesNotExist:
        return JsonResponse({'error': 'Product not foundd'} , status=404)
    
    data = {
        'id' : product.id,
        'name' : product.name,
        'price' : product.price,
        'description': product.description,
        'count': product.count,
        'is_active': product.is_active,
        'category': product.category.name
    }
    return JsonResponse(data)

def category_list(request):
    categories = Category.objects.all()
    data = list(categories.values('id', 'name'))
    return JsonResponse(data, safe=False)   


def category_one(request, id):
    try:
        category = Category.objects.get(id=id)
    except Category.DoesNotExist:
        return JsonResponse({'error': 'Category not found'}, status=404)

    data = {
        'id': category.id,
        'name': category.name
    }
    return JsonResponse(data)


def category_products(request, id):
    try:
        category = Category.objects.get(id=id)
    except Category.DoesNotExist:
        return JsonResponse({'error': 'Category not found'}, status=404)

    products = Product.objects.filter(category=category)
    data = list(products.values('id', 'name', 'price', 'description', 'count', 'is_active'))
    return JsonResponse(data, safe=False)
