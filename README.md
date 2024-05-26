
# API docs

## User endpoints

### Create a new user

```http
  POST /user
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Mandatory**. The name of user to be saved |

#### Request example:

```
{
    "name": "Guilherme"
}
```

#### Response example:

```
{
    "id": 1,
    "name": "Guilherme",
    "expenses": [],
    "totalExpenses": 0.00
}
```

### Find all users

```http
  GET /user
```

#### Response example:
```
[
    {
        "id": 1,
        "name": "Guilherme",
        "expenses": [
            {
                "id": 52,
                "description": "Conta compartilhada. Você pagou o equivalente a 71% do valor total. de R$ 104.90",
                "value": 74.48,
                "type": "INTERNET",
                "creationDate": "2024-05-26T13:57:39.306911",
                "recurrencePeriodInMonths": 1,
                "isRecurrence": true
            },
            {
                "id": 54,
                "description": "Conta compartilhada. Você pagou o equivalente a 71% do valor total. de R$ 600",
                "value": 426.00,
                "type": "RENT",
                "creationDate": "2024-05-26T14:00:46.382536",
                "recurrencePeriodInMonths": 0,
                "isRecurrence": false
            }
        ],
        "totalExpenses": 500.48
    },
    {
        "id": 2,
        "name": "Bill",
        "expenses": [
            {
                "id": 53,
                "description": "Conta compartilhada. Você pagou o equivalente a 29% do valor total. de R$ 104.90",
                "value": 30.42,
                "type": "INTERNET",
                "creationDate": "2024-05-26T13:57:39.325338",
                "recurrencePeriodInMonths": 1,
                "isRecurrence": true
            },
            {
                "id": 55,
                "description": "Conta compartilhada. Você pagou o equivalente a 29% do valor total. de R$ 600",
                "value": 174.00,
                "type": "RENT",
                "creationDate": "2024-05-26T14:00:46.392225",
                "recurrencePeriodInMonths": 0,
                "isRecurrence": false
            }
        ],
        "totalExpenses": 204.42
    }
]
```

#### Find user by id

```http
  GET /user/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Mandatory**. Identifier of user |

#### Response example

```
{
    "id": 1,
    "name": "Guilherme",
    "expenses": [
        {
            "id": 52,
            "description": "Conta compartilhada. Você pagou o equivalente a 71% do valor total. de R$ 104.90",
            "value": 74.48,
            "type": "INTERNET",
            "creationDate": "2024-05-26T13:57:39.306911",
            "recurrencePeriodInMonths": 1,
            "isRecurrence": true
        },
        {
            "id": 54,
            "description": "Conta compartilhada. Você pagou o equivalente a 71% do valor total. de R$ 600",
            "value": 426.00,
            "type": "RENT",
            "creationDate": "2024-05-26T14:00:46.382536",
            "recurrencePeriodInMonths": 0,
            "isRecurrence": false
        }
    ],
    "totalExpenses": 500.48
}
```

### Expense endpoints

#### Create a new expense

```http
   /expense
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `description` | `string` | **Mandatory**. Expense description |
| `value` | `BigDecimal` | **Mandatory**. Expense value |
| `type` | `string` | **Mandatory**. Expense type, which is CARD_INVOICE, ELECTRICITY, WATER, INTERNET, RENT |
| `recurrencePeriodInMonths` | `int` | **Mandatory**. Recurrence period which this recurrence will be active. 0 for unique expense. |
| `userId` | `string` | **Mandatory**. Identifier of user owner of this expense |

#### Request example

```
{
    "description": "Internet",
    "value": 104.90,
    "type": "INTERNET",
    "recurrencePeriodInMonths": "1",
    "userId": 1
}
```

#### Response example

```
{
    "id": 102,
    "description": "Internet",
    "value": 104.90,
    "type": "INTERNET",
    "creationDate": "2024-05-26T14:18:00.853064",
    "recurrencePeriodInMonths": 1,
    "isRecurrence": true
}
```

#### Create a new shared expense

```http
   POST /expense
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `description` | `string` | **Mandatory**. Expense description |
| `value` | `BigDecimal` | **Mandatory**. Expense value |
| `type` | `string` | **Mandatory**. Expense type, which is CARD_INVOICE, ELECTRICITY, WATER, INTERNET, RENT |
| `recurrencePeriodInMonths` | `int` | **Mandatory**. Recurrence period which this recurrence will be active. 0 for unique expense. |
| `users` | `array<expense_user>` | **Mandatory**. List of users that will pay this expense |
| `userId` | `object` | **Mandatory**. Identifier of user that will pay a part of this expense |
| `percentage` | `int` | **Mandatory**. Percentage of expense that will be sent to user.

#### Request example

```
{
    "description": "Aluguel",
    "value": 600,
    "type": "RENT",
    "recurrencePeriodInMonths": "0",
    "users": [
        {
            "userId": 1,
            "percentage": 71
        },
        {
            "userId": 2,
            "percentage": 29
        }
    ]
}
```

#### Response example
* This endpoint has no response