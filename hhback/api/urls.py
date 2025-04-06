from django.urls import path 
from api.views import companies_list, get_one_company, company_vacancies,vacancies_list,get_one_vacancy,list_top_10 , sortedname
from . import views  

urlpatterns = [
    path('companies/' , companies_list),
    path('companies/<int:id>/', get_one_company),
    path('companies/<int:id>/vacancies/', company_vacancies),
    path('vacancies/', vacancies_list),
    path('vacancies/<int:id>/' , get_one_vacancy),
    path('vacancies/top_ten/' , list_top_10),
    path('vacancies/create' , views.create_new_vacancy),
    path('name/' , sortedname),
]