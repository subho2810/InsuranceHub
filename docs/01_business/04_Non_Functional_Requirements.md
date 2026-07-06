# InsuranceHub

# Non-Functional Requirements (NFR)

| **Document Information** |                             |
| ------------------------ | --------------------------- |
| **Document ID**          | INS-NFR-001                 |
| **Project Name**         | InsuranceHub                |
| **Document Name**        | Non-Functional Requirements |
| **Version**              | 1.0                         |
| **Status**               | Draft                       |
| **Author**               | Subhojeet Ghosh             |
| **Reviewer**             | Ace (Solution Architect)    |
| **Date**                 | 04-Jul-2026                 |

---

# Revision History

| Version | Date        | Author          | Description                         |
| ------- | ----------- | --------------- | ----------------------------------- |
| 1.0     | 04-Jul-2026 | Subhojeet Ghosh | Initial Non-Functional Requirements |

---

# 1. Purpose

This document defines the quality attributes and operational characteristics of the InsuranceHub Health Insurance Management System.

These requirements ensure that the system is secure, reliable, scalable, maintainable, and performant.

---

# 2. Scope

This document applies to all components of InsuranceHub, including:

* React Frontend
* FastAPI Gateway
* Spring Boot Data API
* PostgreSQL Database
* Local Infrastructure (Docker & LocalStack)
* Future AWS Deployment

---

# 3. Performance Requirements

| ID           | Requirement                                                                   |
| ------------ | ----------------------------------------------------------------------------- |
| NFR-PERF-001 | Average API response time shall be less than **2 seconds** under normal load. |
| NFR-PERF-002 | Customer login shall complete within **2 seconds**.                           |
| NFR-PERF-003 | File uploads up to **10 MB** shall complete successfully.                     |
| NFR-PERF-004 | Dashboard pages should load within **3 seconds**.                             |

---

# 4. Security Requirements

| ID          | Requirement                                                           |
| ----------- | --------------------------------------------------------------------- |
| NFR-SEC-001 | All passwords shall be encrypted using **bcrypt**.                    |
| NFR-SEC-002 | Authentication shall use **JWT Access Tokens**.                       |
| NFR-SEC-003 | Role-Based Access Control (RBAC) shall restrict system functionality. |
| NFR-SEC-004 | Sensitive configuration values shall be stored outside source code.   |
| NFR-SEC-005 | All API requests shall be validated before processing.                |
| NFR-SEC-006 | Customer documents shall only be accessible to authorized users.      |

---

# 5. Availability Requirements

| ID          | Requirement                                                        |
| ----------- | ------------------------------------------------------------------ |
| NFR-AVL-001 | The application shall recover gracefully from service restarts.    |
| NFR-AVL-002 | Health check endpoints shall be provided for all backend services. |
| NFR-AVL-003 | Critical services shall expose readiness and liveness checks.      |

---

# 6. Reliability Requirements

| ID          | Requirement                                               |
| ----------- | --------------------------------------------------------- |
| NFR-REL-001 | Database transactions shall maintain data consistency.    |
| NFR-REL-002 | Business operations shall prevent partial updates.        |
| NFR-REL-003 | Unexpected errors shall not expose sensitive information. |

---

# 7. Scalability Requirements

| ID          | Requirement                                                     |
| ----------- | --------------------------------------------------------------- |
| NFR-SCL-001 | Backend services shall remain stateless wherever possible.      |
| NFR-SCL-002 | APIs shall support horizontal scaling through containerization. |
| NFR-SCL-003 | Object storage shall support future migration to Amazon S3.     |

---

# 8. Maintainability Requirements

| ID          | Requirement                                                   |
| ----------- | ------------------------------------------------------------- |
| NFR-MNT-001 | Source code shall follow project coding standards.            |
| NFR-MNT-002 | All public APIs shall be documented.                          |
| NFR-MNT-003 | Database schema changes shall be version controlled.          |
| NFR-MNT-004 | Business logic shall remain separate from presentation logic. |

---

# 9. Logging & Monitoring

| ID          | Requirement                                                             |
| ----------- | ----------------------------------------------------------------------- |
| NFR-LOG-001 | User login attempts shall be logged.                                    |
| NFR-LOG-002 | Policy approvals and claim decisions shall be audited.                  |
| NFR-LOG-003 | Application errors shall be logged with timestamps and correlation IDs. |
| NFR-LOG-004 | System metrics shall be available for monitoring.                       |

---

# 10. Usability Requirements

| ID          | Requirement                                                  |
| ----------- | ------------------------------------------------------------ |
| NFR-USE-001 | The application shall provide a responsive web interface.    |
| NFR-USE-002 | Validation messages shall clearly explain user input errors. |
| NFR-USE-003 | Navigation shall remain consistent across modules.           |

---

# 11. Compatibility Requirements

| ID          | Requirement                                                                     |
| ----------- | ------------------------------------------------------------------------------- |
| NFR-CMP-001 | The application shall support the latest versions of Chrome, Edge, and Firefox. |
| NFR-CMP-002 | APIs shall communicate using JSON over HTTPS.                                   |

---

# 12. Backup & Recovery

| ID          | Requirement                                                          |
| ----------- | -------------------------------------------------------------------- |
| NFR-BKP-001 | Database backups shall be supported in production deployments.       |
| NFR-BKP-002 | Uploaded documents shall be recoverable from object storage backups. |

---

# 13. Future Cloud Readiness

| ID          | Requirement                                                                                  |
| ----------- | -------------------------------------------------------------------------------------------- |
| NFR-CLD-001 | LocalStack services shall be replaceable with AWS services without application code changes. |
| NFR-CLD-002 | Infrastructure shall be managed through Terraform.                                           |
| NFR-CLD-003 | Application services shall be deployable using Docker containers.                            |
| NFR-CLD-004 | The solution shall support future deployment to Kubernetes (Amazon EKS or equivalent).       |

---

# 14. Assumptions

* Development will be performed on local infrastructure.
* AWS services will initially be simulated using LocalStack and MinIO where appropriate.
* Internet connectivity is required for application access.

---

# 15. Success Criteria

The InsuranceHub platform shall be considered compliant with this document when all non-functional requirements are validated through testing, monitoring, and deployment verification.

---

# Document Status

**Status:** Draft v1.0

This document establishes the quality standards that every module within InsuranceHub must satisfy throughout development and future production deployment.
