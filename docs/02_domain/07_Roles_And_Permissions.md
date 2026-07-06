# InsuranceHub Platform - Roles & Permissions

## Document Information

| Attribute     | Value               |
| ------------- | ------------------- |
| Document Name | Roles & Permissions |
| Version       | 1.0                 |
| Status        | Approved            |
| Last Updated  | July 2026           |

---

# 1. Purpose

This document defines the Role-Based Access Control (RBAC) model for the InsuranceHub Platform.

Each role is granted only the permissions required to perform its responsibilities, following the Principle of Least Privilege.

---

# 2. Roles

| Role                 | Description                                                    |
| -------------------- | -------------------------------------------------------------- |
| Customer             | Purchases and manages personal insurance policies.             |
| Agent                | Assists assigned customers throughout the insurance lifecycle. |
| Branch Manager       | Reviews and approves claims.                                   |
| System Administrator | Manages system configuration and master data.                  |

---

# 3. Permissions Matrix

| Feature                   | Customer |        Agent       | Branch Manager |   Admin   |
| ------------------------- | :------: | :----------------: | :------------: | :-------: |
| Register Account          |     ✅    |          ❌         |        ❌       |     ✅     |
| Login                     |     ✅    |          ✅         |        ✅       |     ✅     |
| View Own Profile          |     ✅    |          ❌         |        ❌       |     ✅     |
| Update Own Profile        |     ✅    |          ❌         |        ❌       |     ✅     |
| Submit KYC                |     ✅    |          ❌         |        ❌       |     ❌     |
| View Assigned Customers   |     ❌    |          ✅         |        ✅       |     ✅     |
| Verify Customer Documents |     ❌    |          ✅         |        ✅       |     ✅     |
| Approve KYC               |     ❌    |          ❌         |        ❌       |     ✅     |
| Purchase Policy           |     ✅    |     Assist Only    |        ❌       |     ❌     |
| Renew Policy              |     ✅    |     Assist Only    |        ❌       |     ❌     |
| Cancel Policy             |     ✅    |     Assist Only    |        ❌       |     ❌     |
| View Policies             | Own Only | Assigned Customers |     Branch     |    All    |
| Pay Premium               |     ✅    |          ❌         |        ❌       |     ❌     |
| View Payment History      | Own Only | Assigned Customers |     Branch     |    All    |
| Submit Claim              |     ✅    |     Assist Only    |        ❌       |     ❌     |
| Review Claim              |     ❌    |          ❌         |        ✅       | View Only |
| Approve / Reject Claim    |     ❌    |          ❌         |        ✅       |     ❌     |
| Manage Insurance Plans    |     ❌    |          ❌         |        ❌       |     ✅     |
| Manage Branches           |     ❌    |          ❌         |        ❌       |     ✅     |
| View Audit Logs           |     ❌    |          ❌         |        ❌       |     ✅     |

---

# 4. Role Responsibilities

## Customer

* Register an account
* Complete KYC
* Purchase policies
* Pay premiums
* Submit claims
* Renew or cancel policies
* View only personal information

---

## Agent

* Assist assigned customers
* Monitor customer progress
* Verify uploaded documents
* Track policy status
* Cannot modify customer data or approve claims

---

## Branch Manager

* Review submitted claims
* Approve or reject claims
* Monitor branch-level activities
* Cannot modify customer policies

---

## System Administrator

* Manage users
* Manage branches
* Approve KYC
* Configure insurance plans
* View audit reports
* Maintain system master data

---

# 5. Security Principles

The InsuranceHub Platform follows these security principles:

* Least Privilege Access
* Role-Based Access Control (RBAC)
* Customer data privacy
* Full audit logging for critical operations
* JWT-based authentication
* Authorization enforced at the API layer

---

# 6. Future Roles (Out of Scope)

The following roles may be introduced in future versions:

* Claims Auditor
* Fraud Investigator
* Finance Officer
* Customer Support Executive
* Regional Manager
