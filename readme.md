-Describir la solución de dicha implementación, planteando un supuesto
escenario que requiera implementar este patrón, justificándolo en un
comentario o en el Readme del repositorio perteneciente al proyecto.-

El Circuit breaker está implementado en catalog, en el caso de que el usuario
intente acceder a movie-service y éste no pueda proveer información
el circuito se abrirá.

"Swagger": 
-Para acceder a las series sin gateway ni catalog es: /api/v1/series/terror.
-Para crearlas es /api/v1/series/save. 
Y el body va así:

{
        "id": "f15e39c9-ab1e-4982-a66e-31962cc05ae1",
        "name": "Francisca a la carrera 4",
        "genre": "terror",
        "seasons": [
            {
                "seasonNumber": 1,
                "chapters": [
                    {
                        "name": "Chapter A",
                        "number": 1,
                        "urlStream": "www.netflix.com/series/terror/1/season/1/chapter/1"
                    },
                    {
                        "name": "Chapter B",
                        "number": 2,
                        "urlStream": "www.netflix.com/series/terror/1/season/1/chapter/2"
                    }
                ]
            },
            {
                "seasonNumber": 2,
                "chapters": [
                    {
                        "name": "Chapter A",
                        "number": 1,
                        "urlStream": "www.netflix.com/series/terror/1/season/2/chapter/1"
                    },
                    {
                        "name": "Chapter B",
                        "number": 2,
                        "urlStream": "www.netflix.com/series/terror/1/season/2/chapter/2"
                    }
                ]
            }
        ]
    }
Debe devolver el id. 
