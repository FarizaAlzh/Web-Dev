import json
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
from django.shortcuts import get_object_or_404
from api.models import Vacancy, Company , ClassName



# 1 all companies
def companies_list(request):
    companies = Company.objects.all()
    data = { 'Companies' : list(companies.values())}
    return JsonResponse(data)

# 2 only id company
def get_one_company(request, id ):
    company = get_object_or_404(Company , id=id)
    data = { 'Company' : {
            'name' : company.name,
            'description' : company.description,
            'city' : company.city,
            'address' : company.address,
    }}

    return JsonResponse(data)

# 3 company vacancies
def company_vacancies(request, id):
    company = get_object_or_404(Company , id=id)
    vacancies = company.vacancies.all()
    data = {'Vacancies' : list(vacancies.values())}
    return JsonResponse(data)

# 4 list vacancies
def vacancies_list(request):
    vacancy = Vacancy.objects.all()
    data = { 'Vacancies' : list(vacancy.values())}   
    return JsonResponse(data)

#5 get_one_vacancy
def get_one_vacancy(request ,id):
    vacancy = get_object_or_404(Vacancy , id=id)
    data = { 'Vacancy' : {
        'name' : vacancy.name,
        'description' : vacancy.description,
        'salary' : vacancy.salary,
        'company_name' : vacancy.company.name    , 
    }}
    return JsonResponse(data)

#6 list top 10 vacancies sort 
def list_top_10(request):
    vacancies = Vacancy.objects.order_by('-salary')[:10]
    data = { 'Top_10_vacancies' : list(vacancies.values())}
    return JsonResponse(data)

# 7 create vacancy 
@csrf_exempt
def create_new_vacancy(request):
    if request.method == 'POST':
        try:
            data = json.loads(request.body)
            name = data.get('name')
            description = data.get('description')
            salary = data.get('salary')
            company_id = data.get('company')

            if not (name and description and salary and company_id):
                return JsonResponse({'error': 'Missing fields'}, status=400)

            company = get_object_or_404(Company, id=company_id)
            vacancy = Vacancy.objects.create(
                name=name,
                description=description,
                salary=salary,
                company=company
            )

            return JsonResponse({
                'id': vacancy.id,
                'name': vacancy.name,
                'description': vacancy.description,
                'salary': vacancy.salary,
                'company': vacancy.company.id
            }, status=201)
        except json.JSONDecodeError:
            return JsonResponse({'error': 'Invalid JSON'}, status=400)
    return JsonResponse({'error': 'POST request required'}, status=405)


def sortedname(request):
    name = ClassName.objects.order_by('-id')
    data = { 'name' : list(name.values())}
    return JsonResponse(data)