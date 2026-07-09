# Identity Domain

## Version

1.0

---

# Purpose

The Identity Service is responsible for authentication, authorization,
and user identity management within InsuranceHub.

This service acts as the entry point for every authenticated user in the system.

---

# Responsibilities

The Identity Service is responsible for:

- User Registration
- User Authentication
- Password Management
- Role Management
- JWT Token Generation
- Refresh Token Management
- Account Status Management
- Login History
- User Profile Information

---

# Business Goal

Provide a secure and scalable authentication system for all users of
InsuranceHub.

---

# Actors

The system supports multiple types of users.

## Customer

Purchases insurance policies.

Permissions

- Register
- Login
- View Policies
- Pay Premium
- Raise Claims
- Track Claims
- Update Profile

---

## Insurance Agent

Acts as a sales representative.

Permissions

- Create Customer
- Recommend Policies
- View Assigned Customers

---

## Branch Manager

Approves policy purchases after successful premium payment.

Permissions

- Approve Policies
- Reject Policies
- View Branch Dashboard

---

## Claims Officer

Processes insurance claims.

Permissions

- Review Claims
- Approve Claims
- Reject Claims

---

## Underwriter

Evaluates insurance risk before policy approval.

Permissions

- Risk Assessment
- Policy Evaluation

---

## Administrator

Maintains the platform.

Permissions

- Manage Users
- Manage Roles
- View Audit Logs
- Lock Accounts
- Unlock Accounts

---

# User Lifecycle

New User
        │
        ▼
Registered
        │
        ▼
Email Verified
        │
        ▼
Active
        │
        ▼
Login
        │
        ▼
Authenticated

Possible states

- Locked
- Disabled
- Deleted

---

# Authentication Flow

User

↓

Login Request

↓

Identity Service

↓

Validate Credentials

↓

Generate JWT

↓

Return Access Token

↓

Access Protected APIs

---

# Registration Flow

User

↓

Registration Request

↓

Validate Data

↓

Check Email Exists

↓

Encrypt Password

↓

Save User

↓

Return Success Response

---

# Password Policy

Minimum length: 8

Must contain:

- Uppercase Letter
- Lowercase Letter
- Number
- Special Character

Passwords are never stored in plain text.

Passwords are encrypted using BCrypt.

---

# Account Status

ACTIVE

User can login.

LOCKED

User cannot login.

DISABLED

Account disabled by administrator.

PENDING_VERIFICATION

Email verification pending.

DELETED

Soft deleted account.

---

# Future Enhancements

- Multi-Factor Authentication (MFA)
- OTP Login
- Google Login
- Microsoft Login
- Password History
- Device Management
- Session Management
- Remember Me
- Login Notifications
- Risk-based Authentication

---

# Dependencies

Identity Service communicates with:

- Customer Service
- Policy Service
- Notification Service
- Audit Service

---

# Events Published

User Registered

User Logged In

Password Changed

Account Locked

Account Unlocked

Role Assigned

---

# Events Consumed

Customer Created

Policy Purchased

Policy Approved

---

# Design Principles

- Stateless Authentication
- JWT Based Security
- BCrypt Password Encryption
- Role Based Access Control (RBAC)
- Principle of Least Privilege
- Soft Delete
- Audit Friendly

---

## User Role Strategy

A user can have exactly one role.

Reasons:

- Simpler authorization model
- Matches current InsuranceHub business rules
- Easier maintenance
- Can be extended in the future if required

# Status

Approved for Sprint 1