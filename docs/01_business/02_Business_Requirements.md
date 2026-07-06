# InsuranceHub

# Business Requirements Document (BRD)

| **Document Information** |                                |
| ------------------------ | ------------------------------ |
| **Document ID**          | INS-BRD-001                    |
| **Project Name**         | InsuranceHub                   |
| **Document Name**        | Business Requirements Document |
| **Version**              | 1.0                            |
| **Status**               | Draft                          |
| **Author**               | Subhojeet Ghosh                |
| **Reviewer**             | Ace (Solution Architect)       |
| **Date**                 | 04-Jul-2026                    |

---

# Revision History

| Version | Date        | Author          | Description                            |
| ------- | ----------- | --------------- | -------------------------------------- |
| 1.0     | 04-Jul-2026 | Subhojeet Ghosh | Initial Business Requirements Document |

---

# Table of Contents

1. Introduction
2. Business Overview
3. Business Objectives
4. Business Scope
5. Stakeholders
6. User Roles
7. Business Processes
8. Business Requirements
9. Business Rules
10. Assumptions
11. Constraints
12. Success Criteria

---

# 1. Introduction

## Purpose

The purpose of this document is to define the business requirements for the InsuranceHub Health Insurance Management System.

This document serves as the primary reference for business stakeholders, architects, developers, testers, and future maintainers throughout the software development lifecycle.

## Project Overview

InsuranceHub is a centralized web-based platform that enables customers, insurance agents, branch managers, and administrators to manage the complete health insurance lifecycle.

The platform supports customer onboarding, policy issuance, premium collection, document management, claim processing, reporting, and administrative operations.

---

# 2. Business Overview

InsuranceHub is a fictional health insurance company headquartered in Kolkata with branch offices across India.

The organization currently requires a digital platform capable of managing:

* Customer onboarding
* Health insurance plans
* Policy lifecycle
* Premium payments
* Claim processing
* Document verification
* Branch operations
* Administrative activities

The system will standardize business operations while improving customer experience and operational efficiency.

---

# 3. Business Objectives

The primary objectives of InsuranceHub are:

* Digitize health insurance operations.
* Reduce manual processing.
* Improve policy issuance efficiency.
* Accelerate claim processing.
* Enhance customer satisfaction.
* Provide centralized branch management.
* Improve transparency and auditability.
* Enable business reporting and analytics.

---

# 4. Business Scope

## In Scope

### Customer Management

* Customer registration
* Customer profile management
* KYC verification

### Policy Management

* Policy recommendation
* Policy creation
* Policy approval
* Policy activation
* Policy renewal
* Policy cancellation

### Claims

* Claim creation
* Claim review
* Claim approval
* Claim settlement

### Payments

* Premium payment
* Payment history
* Receipt generation

### Documents

* Upload
* Verification
* Storage
* Retrieval

### Administration

* User management
* Branch management
* Role management
* Audit logging

---

## Out of Scope

* Mobile application
* Online payment gateway integration
* SMS notifications
* Hospital management integration
* AI fraud detection
* OCR document scanning
* Multi-language support

---

# 5. Stakeholders

| Stakeholder      | Responsibility                     |
| ---------------- | ---------------------------------- |
| Customer         | Purchase policies and raise claims |
| Insurance Agent  | Manage customers and policies      |
| Branch Manager   | Approve policies and claims        |
| Administrator    | Manage users and branches          |
| Development Team | Build and maintain the platform    |

---

# 6. User Roles

## Customer

Responsible for:

* Registration
* Profile management
* Uploading documents
* Viewing policies
* Paying premiums
* Raising claims

---

## Insurance Agent

Responsible for:

* Verifying customers
* Recommending policies
* Creating policies
* Reviewing claims

---

## Branch Manager

Responsible for:

* Approving policies
* Approving claims
* Monitoring branch performance

---

## Administrator

Responsible for:

* Managing users
* Managing branches
* Managing system configuration
* Viewing audit logs

---

# 7. Business Processes

The system shall support the following core business processes:

1. Customer Onboarding
2. Policy Purchase
3. Premium Payment
4. Policy Renewal
5. Claim Processing
6. Document Verification
7. Branch Management
8. Reporting

Each process will be elaborated in dedicated workflow documentation.

---

# 8. Business Requirements

The system shall:

* Allow customers to register online.
* Allow customers to upload KYC documents.
* Allow agents to verify customer information.
* Allow agents to recommend health insurance plans.
* Allow agents to create policies.
* Require branch manager approval before policy issuance.
* Allow customers to pay insurance premiums.
* Activate policies after successful payment.
* Allow customers to raise insurance claims.
* Allow agents to review claims.
* Allow branch managers to approve or reject claims.
* Generate payment receipts.
* Maintain audit logs for critical business actions.

---

# 9. Business Rules

The following business rules apply:

1. A customer must belong to exactly one branch.
2. A customer may own multiple policies.
3. A policy belongs to one customer.
4. Only approved customers may purchase policies.
5. Policies require branch manager approval before issuance.
6. Premium payment activates the policy.
7. Claims may only be raised against active policies.
8. Required supporting documents must be uploaded before claim review.
9. Every approval action must be recorded in the audit log.
10. Role-based access control applies to all system users.

---

# 10. Assumptions

* Customers have internet access.
* Agents perform customer verification.
* Branch managers approve business-critical transactions.
* Development is performed in a local environment.
* The system is designed for future cloud deployment.

---

# 11. Constraints

* Local-first development.
* No paid cloud infrastructure during development.
* Modular microservice architecture.
* PostgreSQL as the primary relational database.
* Object storage through an S3-compatible local solution.

---

# 12. Success Criteria

The project shall be considered successful when:

* All Version 1 business requirements are implemented.
* Business workflows are fully operational.
* Customers can complete the insurance lifecycle.
* Branch operations are centralized.
* Business reports are generated successfully.
* Documentation remains synchronized with implementation.

---

# Document Status

**Status:** Draft v1.0

This Business Requirements Document establishes the functional expectations of the InsuranceHub platform from a business perspective. Technical implementation details are intentionally excluded and will be documented separately in the Functional Requirements Document (FRD), High-Level Design (HLD), and subsequent architecture artifacts.
