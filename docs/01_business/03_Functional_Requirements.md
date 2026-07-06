# InsuranceHub

# Functional Requirements Document (FRD)

| **Document Information** |                                  |
| ------------------------ | -------------------------------- |
| **Document ID**          | INS-FRD-001                      |
| **Project Name**         | InsuranceHub                     |
| **Document Name**        | Functional Requirements Document |
| **Version**              | 1.0                              |
| **Status**               | Draft                            |
| **Author**               | Subhojeet Ghosh                  |
| **Reviewer**             | Ace (Solution Architect)         |
| **Date**                 | 04-Jul-2026                      |

---

# Revision History

| Version | Date        | Author          | Description                                  |
| ------- | ----------- | --------------- | -------------------------------------------- |
| 1.0     | 04-Jul-2026 | Subhojeet Ghosh | Initial Functional Requirements for Sprint 1 |

---

# 1. Purpose

The purpose of this document is to define the functional behavior of the InsuranceHub Health Insurance Management System.

This document translates the business requirements into system requirements that guide design, development, testing, and deployment.

---

# 2. Scope

Version 1.0 covers the functional requirements for **Sprint 1 – Customer Onboarding and Authentication**.

Included modules:

* Authentication
* Customer Management

Future versions of this document will include:

* Policy Management
* Claims Management
* Payments
* Administration
* Reporting
* Notifications

---

# 3. Functional Modules

| Module ID | Module Name         |
| --------- | ------------------- |
| AUTH      | Authentication      |
| CUST      | Customer Management |

---

# 4. Functional Requirements

---

## Authentication Module

---

### FR-AUTH-001

| Field    | Value               |
| -------- | ------------------- |
| Feature  | Customer Login      |
| Priority | High                |
| Actor    | Registered Customer |

**Description**

The system shall authenticate registered customers using their email address and password.

**Preconditions**

* Customer account exists.
* Email has been verified.
* Customer account is active.

**Postconditions**

* JWT access token is generated.
* User session is created.
* Login audit entry is recorded.

**Acceptance Criteria**

* Valid credentials allow login.
* Invalid credentials display an error.
* Locked accounts cannot log in.

---

### FR-AUTH-002

| Field    | Value              |
| -------- | ------------------ |
| Feature  | Email Verification |
| Priority | High               |
| Actor    | Customer           |

**Description**

The system shall verify a customer's email address before allowing login.

**Acceptance Criteria**

* Verification link is accepted.
* Invalid or expired links are rejected.
* Customer status changes to VERIFIED.

---

### FR-AUTH-003

| Field    | Value           |
| -------- | --------------- |
| Feature  | Forgot Password |
| Priority | Medium          |
| Actor    | Customer        |

**Description**

The system shall allow customers to request a password reset.

**Acceptance Criteria**

* Password reset request is generated.
* Reset token expires after the configured duration.
* Successful reset invalidates previous tokens.

---

### FR-AUTH-004

| Field    | Value              |
| -------- | ------------------ |
| Feature  | Logout             |
| Priority | High               |
| Actor    | Authenticated User |

**Description**

The system shall terminate the user's authenticated session.

**Acceptance Criteria**

* JWT/session is invalidated.
* Protected resources are inaccessible after logout.

---

## Customer Management Module

---

### FR-CUST-001

| Field    | Value                 |
| -------- | --------------------- |
| Feature  | Customer Registration |
| Priority | High                  |
| Actor    | Visitor               |

**Description**

The system shall allow visitors to register as customers.

**Input Fields**

* First Name
* Last Name
* Email Address
* Mobile Number
* Password
* Confirm Password

**Validation Rules**

* Email must be unique.
* Mobile number must be unique.
* Password must contain:

  * Minimum 8 characters
  * One uppercase letter
  * One lowercase letter
  * One number
  * One special character.

**Postconditions**

* Customer account is created.
* Status = PENDING_EMAIL_VERIFICATION.

**Acceptance Criteria**

* Registration succeeds with valid data.
* Duplicate email is rejected.
* Duplicate mobile number is rejected.
* Weak passwords are rejected.

---

### FR-CUST-002

| Field    | Value            |
| -------- | ---------------- |
| Feature  | Customer Profile |
| Priority | High             |
| Actor    | Customer         |

**Description**

The system shall allow customers to complete and update their personal profile.

**Profile Information**

* Date of Birth
* Gender
* Address
* Occupation
* Annual Income
* Emergency Contact

**Acceptance Criteria**

* Profile updates are saved successfully.
* Mandatory fields are validated.
* Audit trail is maintained.

---

### FR-CUST-003

| Field    | Value                |
| -------- | -------------------- |
| Feature  | Upload KYC Documents |
| Priority | High                 |
| Actor    | Customer             |

**Description**

The system shall allow customers to upload KYC and supporting documents.

**Supported Document Types**

* Aadhaar Card
* PAN Card
* Passport (Optional)
* Driving Licence (Optional)

**Acceptance Criteria**

* Supported file formats are accepted.
* Invalid file types are rejected.
* Uploaded documents remain in PENDING_VERIFICATION status.

---

### FR-CUST-004

| Field    | Value              |
| -------- | ------------------ |
| Feature  | Agent Verification |
| Priority | High               |
| Actor    | Insurance Agent    |

**Description**

The system shall allow insurance agents to review and verify customer KYC documents.

**Acceptance Criteria**

* Agent can approve documents.
* Agent can reject documents with comments.
* Customer status updates automatically.
* Verification activity is recorded in the audit log.

---

# 5. Business Rules Reference

This document references the following business rules defined in the Business Requirements Document (BRD):

* BR-001: Customer must belong to one branch.
* BR-002: Customer must complete KYC before policy purchase.
* BR-003: Only approved customers may purchase insurance policies.
* BR-004: Every critical business action shall be audited.

---

# 6. Non-Functional Dependencies

The functional requirements rely on the following non-functional capabilities:

* Authentication
* Authorization
* Audit Logging
* Secure Password Storage
* File Storage
* Session Management
* Input Validation

Detailed non-functional requirements will be defined in the Non-Functional Requirements Document (NFR).

---

# 7. Traceability

Each functional requirement shall be mapped to:

* Business Requirement
* API Endpoint
* Database Table
* User Interface Screen
* Test Case

A dedicated Requirements Traceability Matrix (RTM) will maintain these mappings.

---

# 8. Future Enhancements

The following modules will be added in future versions of this document:

* Policy Management
* Insurance Plans
* Premium Payments
* Claims Management
* Notifications
* Reporting
* Branch Administration
* System Administration

---

# Document Status

**Status:** Draft v1.0

This document defines the functional behavior of Sprint 1 and will be expanded incrementally as new business capabilities are introduced into InsuranceHub.
