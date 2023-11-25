# TpEspecialArqWeb

## Crear tipo de usuario

POST http://localhost:8008/auth/register
  {
      "username": "AdminService",
      "password": "124"
  }
  En el username se indicara que tipo de usuario es "MaintenanceService", "AdminService", "AccountService", "TravelService", "MonopatinService", todos pueden acceder a cualquier microservicio exepto microservicio-administracion que solo se podra acceder con una cuenta de tipo AdminService.

## Crear Monopatin

POST http://localhost:8003/monopatines
    {
        "gps": 2141,
        "locacion": "Tandil",
        "estado": "disponible"
    }
## Remover Monopatin

DELETE http://localhost:8003/monopatines/{ID}

## Crear Cuenta

POST http://localhost:8005/cuentas/{id_mercadoPago}
crea la cuenta con la id mercado pago

## Modificar datos Cuenta

PUT http://localhost:8005/cuentas/1
{
    "id_mercado_pago": 1,
    "saldo": 2420.0,
    "isHabilitada": true,
    "fecha_alta": "2023-11-22T10:53:29"
}

PUT http://localhost:8005/cuentas/{id}/cargarSaldo/{cant_saldo}

PUT http://localhost:8005/cuentas/{id}/restarSaldo/{cant_saldo}

## Crear Usuario

POST http://localhost:8005/usuarios
    {
      "nombre": "Sergio",
      "password": "123"
      "email": "sergio@gmail.com"
    }

## Obtener Monopatines cercanos a una locacion

g. Como usuario quiero lun listado de los monopatines cercanos a mi zona, para poder encontrar
un monopatín cerca de mi ubicación

GET http://localhost:8005/usuarios/locacion/tandil

## Administrador

## Cambiar Estado Monopatin

PUT http://localhost:8001/administradores/monopatines/{id}/estado/{estado}
estado = mantenimiento o disponible

## Cambiar Estado Cuenta
b. Como administrador quiero poder anular cuentas para inhabilitar el uso momentáneo de la
misma.

PUT http://localhost:8001/administradores/cuentas/{id}?habilitada=false

## Comparar cantidad de estados Monopatines
e. Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
versus la cantidad de monopatines actualmente en mantenimiento.

GET http://localhost:8001/administradores/monopatines/estados
Compara la cantidad de monopatines en mantenimiento con los que estan disponibles

## Crear Tarifa

POST Tarifa http://localhost:8001/administradores/tarifas
{
    "clave": "123",
    "valor": 12.0,
    "valorPorPausa": 20.0,
    "fechaEntradaVigencia": "2023-11-09"
}

c. Como administrador quiero consultar los monopatines con más de X viajes en un cierto año

GET http://localhost:8001/administradores/reportes/cantidadViajesMayorA/1/anio/2020
Muestra los monopatines con mayor cantidad de viajes a en este caso 1 en un año(2020)

---------------------------------------------------------------------------------------------

d. Como administrador quiero consultar el total facturado en un rango de meses de cierto año

GET http://localhost:8001/administradores/facturacionViajesDesde/1/hasta/5/anio/2020
Muestra la facturacion dentro de un rango de meses y año

----------------------------------------------------------------------------------------------

GET http://localhost:8001/administradores/reportes/monopatines/kilometros
Ordena por kilometros recorridos desc

---------------------------------------------------------------------------------------------

a. Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
configurarse para incluir (o no) los tiempos de pausa

GET http://localhost:8001/administradores/reportes/monopatines/tiempos/conPausas
Ordena por tiempos los monopatines que tuvieron pausas

GET http://localhost:8001/administradores/reportes/monopatines/tiempos/sinPausas
Ordena por tiempos los monopatines que no tuvieron pausas
