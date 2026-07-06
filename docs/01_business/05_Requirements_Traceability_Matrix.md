# InsuranceHub

# Requirements Traceability Matrix (RTM)

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-RTM-001              |
| **Project Name**         | InsuranceHub             |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |

---

# Purpose

This document provides end-to-end traceability between business requirements, functional requirements, user interface components, backend APIs, database entities, and test cases.

It ensures every implemented feature can be traced back to a business need.

---

# Sprint 1 Traceability Matrix

| BR ID  | FR ID       | Feature               | UI Screen            | API Endpoint                       | Database Entity | Test Case   | Sprint   |
| ------ | ----------- | --------------------- | -------------------- | ---------------------------------- | --------------- | ----------- | -------- |
| BR-001 | FR-CUST-001 | Customer Registration | Registration Page    | POST /api/v1/customers/register    | Customer        | TC-CUST-001 | Sprint 1 |
| BR-002 | FR-AUTH-001 | Customer Login        | Login Page           | POST /api/v1/auth/login            | User            | TC-AUTH-001 | Sprint 1 |
| BR-002 | FR-AUTH-002 | Email Verification    | Verify Email Page    | GET /api/v1/auth/verify            | User            | TC-AUTH-002 | Sprint 1 |
| BR-003 | FR-AUTH-003 | Forgot Password       | Forgot Password Page | POST /api/v1/auth/forgot-password  | User            | TC-AUTH-003 | Sprint 1 |
| BR-003 | FR-AUTH-004 | Logout                | Header Menu          | POST /api/v1/auth/logout           | Session         | TC-AUTH-004 | Sprint 1 |
| BR-004 | FR-CUST-002 | Customer Profile      | Profile Page         | PUT /api/v1/customers/profile      | Customer        | TC-CUST-002 | Sprint 1 |
| BR-005 | FR-CUST-003 | Upload KYC            | KYC Upload Page      | POST /api/v1/documents/upload      | Document        | TC-CUST-003 | Sprint 1 |
| BR-006 | FR-CUST-004 | Agent Verification    | Agent Dashboard      | PUT /api/v1/agents/verify-customer | Customer        | TC-CUST-004 | Sprint 1 |

---

# Notes

* Every Business Requirement (BR) should map to one or more Functional Requirements (FR).
* Every Functional Requirement should map to at least one UI screen, API endpoint, database entity, and test case.
* This matrix will be updated at the end of every sprint to maintain complete traceability throughout the project lifecycle.
