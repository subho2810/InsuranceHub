# InsuranceHub

# Project Charter

| **Document Information** |                          |
| ------------------------ | ------------------------ |
| **Document ID**          | INS-CH-001               |
| **Project Name**         | InsuranceHub             |
| **Document Name**        | Project Charter          |
| **Version**              | 1.0                      |
| **Status**               | Draft                    |
| **Author**               | Subhojeet Ghosh          |
| **Reviewer**             | Ace (Solution Architect) |
| **Date**                 | 03-Jul-2026              |

---

# Revision History

| Version | Date        | Author          | Description             |
| ------- | ----------- | --------------- | ----------------------- |
| 1.0     | 03-Jul-2026 | Subhojeet Ghosh | Initial Project Charter |

---

# Table of Contents

1. Executive Summary
2. Business Problem
3. Vision Statement
4. Project Objectives
5. Project Scope
6. Stakeholders
7. Organization Structure
8. Assumptions
9. Constraints
10. Risks
11. Success Criteria
12. Project Milestones
13. Technology Strategy
14. Approval

---

# 1. Executive Summary

InsuranceHub is a web-based Health Insurance Management System designed to support a multi-branch insurance company operating across India.

The platform provides a centralized solution for managing customers, health insurance policies, premium payments, claims, documents, notifications, reporting, and administrative activities.

The application will be developed using a modern microservice architecture and cloud-native design principles while running completely in a local development environment. This allows enterprise-grade development without requiring paid cloud infrastructure.

---

# 2. Business Problem

The organization currently relies on multiple disconnected systems and manual processes to manage health insurance operations.

This results in:

* Duplicate customer records
* Slow policy issuance
* Delayed claim processing
* Inefficient document management
* Limited visibility across branches
* Inconsistent reporting
* Difficult audit tracking
* Increased operational effort

InsuranceHub aims to provide a single integrated platform that standardizes and automates these business processes.

---

# 3. Vision Statement

> Build a secure, scalable, and maintainable Health Insurance Management System that digitizes the complete insurance lifecycle while following enterprise software engineering and cloud-native architecture principles.

---

# 4. Project Objectives

## Business Objectives

* Centralize health insurance operations.
* Improve customer experience.
* Reduce manual work.
* Standardize policy management.
* Improve claim processing efficiency.
* Support multiple branches across India.
* Increase operational visibility.

## Technical Objectives

* Build an enterprise-grade application.
* Follow modern software architecture practices.
* Use a microservice-oriented design.
* Maintain comprehensive project documentation.
* Develop locally using AWS-compatible services.
* Follow Agile development practices.
* Produce a portfolio-quality project.

---

# 5. Project Scope

## In Scope (Version 1)

### Authentication

* User Login
* JWT Authentication
* Role-Based Authorization

### Customer Management

* Register Customer
* Update Customer
* Search Customer
* View Customer Profile

### Policy Management

* Create Policy
* View Policy
* Update Policy
* Renew Policy
* Cancel Policy

### Claims Management

* Raise Claim
* Upload Claim Documents
* Review Claim
* Approve Claim
* Reject Claim
* Track Claim Status

### Payments

* Record Premium Payment
* View Payment History
* Generate Payment Receipt

### Document Management

* Upload Documents
* Download Documents
* Delete Documents

### Dashboard & Reports

* Dashboard
* Branch Reports
* Policy Reports
* Claim Reports

### Administration

* User Management
* Role Management
* Branch Management
* Audit Logs

---

## Out of Scope (Version 1)

The following features are intentionally excluded from the first release:

* Mobile Application
* Payment Gateway Integration
* SMS Notifications
* AI Fraud Detection
* Hospital System Integration
* OCR Document Processing
* Multi-language Support
* Chatbot Integration

---

# 6. Stakeholders

| Stakeholder      | Responsibility                                      |
| ---------------- | --------------------------------------------------- |
| Customer         | Purchase policies, raise claims, manage payments    |
| Insurance Agent  | Manage customers and policies                       |
| Branch Manager   | Supervise branch operations and approve claims      |
| Administrator    | Manage users, roles, and system configuration       |
| Development Team | Design, develop, test, and maintain the application |

---

# 7. Organization Structure

```text
InsuranceHub (Head Office)
│
├── Kolkata Branch
├── Mumbai Branch
├── Bengaluru Branch
└── Delhi Branch
```

Each branch consists of:

* Branch Manager
* Insurance Agents
* Customers

---

# 8. Assumptions

* Each customer belongs to one branch.
* A customer may own multiple health insurance policies.
* Claims can only be raised for active policies.
* Each policy belongs to one customer.
* Users access the system using a web browser.
* The application is developed and executed locally during development.

---

# 9. Constraints

* No paid cloud infrastructure will be used during development.
* The system must run using local services.
* Docker will be used for containerization.
* Documentation must be maintained throughout the project lifecycle.
* The architecture should support future cloud deployment with minimal changes.

---

# 10. Risks

| Risk                             | Impact | Mitigation                                           |
| -------------------------------- | ------ | ---------------------------------------------------- |
| Increasing project scope         | High   | Maintain a defined MVP and defer additional features |
| Technology learning curve        | Medium | Build incrementally with documentation               |
| Environment configuration issues | Medium | Use Docker Compose and setup guides                  |
| Data loss during development     | Low    | Use Git version control and regular backups          |

---

# 11. Success Criteria

The project will be considered successful when:

* All Version 1 functional requirements are implemented.
* Users can complete the end-to-end insurance workflow.
* Automated testing passes.
* Documentation is complete.
* The application runs successfully in a local environment.
* The architecture supports future deployment to AWS with minimal changes.

---

# 12. Project Milestones

| Milestone | Deliverable                                      |
| --------- | ------------------------------------------------ |
| M1        | Documentation Complete                           |
| M2        | Architecture Approved                            |
| M3        | Local Development Environment Ready              |
| M4        | Authentication Module                            |
| M5        | Customer Management Module                       |
| M6        | Policy Management Module                         |
| M7        | Claims Management Module                         |
| M8        | Payments & Documents Module                      |
| M9        | Local Infrastructure (Docker, MinIO, LocalStack) |
| M10       | Version 1.0 Release                              |

---

# 13. Technology Strategy

| Layer                   | Technology              |
| ----------------------- | ----------------------- |
| Frontend                | React 18 + TypeScript   |
| API Gateway             | FastAPI                 |
| Business Service        | Spring Boot 3 (Java 21) |
| Database                | PostgreSQL              |
| ORM                     | Spring Data JPA         |
| Validation              | Pydantic                |
| Object Storage          | MinIO                   |
| Local Cloud Services    | LocalStack              |
| Session Store           | DynamoDB Local          |
| Containerization        | Docker & Docker Compose |
| Container Orchestration | Kind / Minikube         |
| Infrastructure as Code  | Terraform               |
| CI/CD                   | GitHub Actions          |
| GitOps                  | ArgoCD                  |

---

# 14. Approval

| Role               | Name            | Status         |
| ------------------ | --------------- | -------------- |
| Product Owner      | Subhojeet Ghosh | Pending        |
| Solution Architect | Ace             | Draft Approved |

---

## Document Status

**Status:** Draft v1.0

This document serves as the foundational charter for the InsuranceHub project. It defines the project's purpose, scope, objectives, and governance. All subsequent documents—including the Business Requirements Document (BRD), High-Level Design (HLD), Low-Level Design (LLD), API Specifications, and Database Design—must align with the decisions documented here.
