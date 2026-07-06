# InsuranceHub

# Domain Events

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-DOM-004              |
| **Project Name**         | InsuranceHub             |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |

---

# 1. Purpose

This document defines the domain events published and consumed within InsuranceHub. These events enable communication between microservices using an event-driven architecture while maintaining loose coupling and scalability.

---

# 2. Event Naming Convention

InsuranceHub follows a domain-based event naming convention.

**Format**

```
<domain>.<action>
```

Examples:

* customer.registered
* customer.kyc.approved
* policy.issued
* payment.premium.paid
* claim.submitted

---

# 3. Event Categories

| Category            | Description                             |
| ------------------- | --------------------------------------- |
| Customer Events     | Customer registration and KYC lifecycle |
| Policy Events       | Policy lifecycle events                 |
| Payment Events      | Premium payment events                  |
| Claim Events        | Claim lifecycle events                  |
| Notification Events | Communication events                    |
| Audit Events        | Security and audit logging              |

---

# 4. Event Catalogue

| Event                        | Publisher        | Primary Subscribers           |
| ---------------------------- | ---------------- | ----------------------------- |
| customer.registered          | Customer Service | Notification, Audit           |
| customer.kyc.submitted       | Customer Service | Audit                         |
| customer.kyc.approved        | Customer Service | Policy, Notification, Audit   |
| customer.kyc.rejected        | Customer Service | Notification, Audit           |
| policy.application.submitted | Policy Service   | Audit                         |
| policy.issued                | Policy Service   | Notification, Customer, Audit |
| policy.renewed               | Policy Service   | Notification, Audit           |
| policy.cancelled             | Policy Service   | Notification, Payment, Audit  |
| payment.premium.paid         | Payment Service  | Policy, Notification, Audit   |
| payment.failed               | Payment Service  | Notification, Audit           |
| payment.refunded             | Payment Service  | Notification, Audit           |
| claim.submitted              | Claims Service   | Notification, Audit           |
| claim.approved               | Claims Service   | Payment, Notification, Audit  |
| claim.rejected               | Claims Service   | Notification, Audit           |
| claim.settled                | Claims Service   | Notification, Audit           |

---

# 5. Standard Event Structure

Every event shall contain:

* Event ID
* Event Name
* Event Version
* Event Timestamp
* Source Service
* Correlation ID
* Payload

Example:

```json
{
  "eventId": "uuid",
  "eventName": "policy.issued",
  "eventVersion": "1.0",
  "timestamp": "2026-07-06T10:30:00Z",
  "source": "policy-service",
  "correlationId": "uuid",
  "payload": {}
}
```

---

# 6. Event Flow Principles

* Services publish events after successful business transactions.
* Services shall not directly invoke other services when an event-driven alternative exists.
* Multiple services may subscribe to the same event.
* Publishers are not aware of subscribers.

---

# 7. Event Versioning

Each event shall include an `eventVersion` field.

Initial version:

```
1.0
```

Future versions must maintain backward compatibility whenever possible.

---

# 8. Error Handling

If event processing fails:

1. Retry processing.
2. Log the failure.
3. Move the event to a Dead Letter Queue (DLQ) after the configured retry limit.
4. Notify administrators if manual intervention is required.

---

# 9. Retry Strategy

InsuranceHub will follow an exponential backoff retry strategy.

Example:

* Retry 1 → 5 seconds
* Retry 2 → 15 seconds
* Retry 3 → 30 seconds

After the final retry, the event will be moved to the DLQ.

---

# 10. Dead Letter Queue (DLQ)

Failed events shall be stored in a Dead Letter Queue for investigation and replay.

Typical reasons include:

* Invalid payload
* Temporary service outage
* Database errors
* Processing timeout

---

# 11. Idempotency

Event consumers must process duplicate events safely.

Processing the same event multiple times shall not produce duplicate business operations.

---

# 12. Correlation ID

Every event shall include a Correlation ID.

This identifier allows end-to-end tracing of a business transaction across multiple services.

---

# 13. Future Enhancements

Future versions may include:

* Event schema validation
* Event replay support
* Event archival
* Event encryption
* Event signing
* Distributed tracing integration (OpenTelemetry)

---

# 14. Version History

| Version | Date        | Description                     |
| ------- | ----------- | ------------------------------- |
| 1.0     | 06-Jul-2026 | Initial Domain Events document. |
