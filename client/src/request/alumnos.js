export const alumnos = [
    {
      "dni": "12345678",
      "nombre": "Juan",
      "apellido": "Pérez",
      "fechaDeNacimiento": "2001-05-20",
      "carrera": {
        "uuid": "550e8400-e29b-41d4-a716-446655440000",
        "nombre": "Ingeniería en Sistemas",
        "duracion": 5,
        "precioInscripcion": 15000,
        "precioCuota": 8000,
        "coordinador": {
          "id": "550e8400-e29b-41d4-a716-446655440001",
          "nombre": "María García"
        }
      },
      "estados": [
        {
          "id": 1,
          "materia": {
            "id": 101,
            "nombre": "Matemáticas",
            "curso": 1,
            "cuatrimestre": "Primer"
          },
          "estado": "Aprobado",
          "fecha": "2023-06-15"
        },
        {
          "id": 2,
          "materia": {
            "id": 102,
            "nombre": "Física",
            "curso": 1,
            "cuatrimestre": "Primer"
          },
          "estado": "Cursando",
          "fecha": "2023-09-01"
        }
      ]
    },
    {
      "dni": "87654321",
      "nombre": "Ana",
      "apellido": "Gómez",
      "fechaDeNacimiento": "2000-11-30",
      "carrera": {
        "uuid": "550e8400-e29b-41d4-a716-446655440002",
        "nombre": "Contador Público",
        "duracion": 4,
        "precioInscripcion": 12000,
        "precioCuota": 7000,
        "coordinador": {
          "id": "550e8400-e29b-41d4-a716-446655440003",
          "nombre": "Carlos Rodríguez"
        }
      },
      "estados": [
        {
          "id": 3,
          "materia": {
            "id": 201,
            "nombre": "Contabilidad",
            "curso": 1,
            "cuatrimestre": "Segundo"
          },
          "estado": "Aprobado",
          "fecha": "2023-07-10"
        },
        {
          "id": 4,
          "materia": {
            "id": 202,
            "nombre": "Economía",
            "curso": 1,
            "cuatrimestre": "Segundo"
          },
          "estado": "Cursando",
          "fecha": "2023-09-01"
        }
      ]
    }
  ]