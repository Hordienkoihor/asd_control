Профіль оплати P6: CardPayment: дозволяє суму до 45_000; PayPalPayment: приймає суму від 600; BankTransferPayment: комісія 0.5% для сум >= 50_000, інакше 2%.
Пакет правил R9: валідація - сума однієї позиції не може перевищувати 50_000.
Знижки/комісії: знижка 20% для категорії CLEARANCE.
Переходи станів: NEW -> PAID -> SHIPPED -> DELIVERED -> ARCHIVED.
Додатковий крок Template Method: реалізувати крок archiveAfterDelivery.
Обов'язковий негативний сценарій: передбачити і протестувати виняток ArchiveOperationException.