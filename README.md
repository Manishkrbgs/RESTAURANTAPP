# Restaurant Management Service

This is a Restaurant Management Service that allows users to place orders, admins to manage food items, and visitors to view the available items. The service includes a sign-in and sign-up system for both admins and users.

## Entities

The service includes the following entities:

- User: Represents a registered user with details such as name, email, and password.
- Admin: Represents an administrator with additional privileges for managing food items.
- Visitor: Represents a visitor who can view the available food items.
- Order: Represents an order placed by a user, containing details such as order ID, user ID, and order items.
- Food Item: Represents a food item in the restaurant menu, with details like item ID, name, price, etc.

## Sign-in and Sign-up System

The service provides sign-in and sign-up functionality for both admins and users. The credentials are stored securely using MD5 password encryption.

### APIs

The following APIs are available for authentication:

- `POST /api/signup/user`: Sign up a new user with details like name, email, and password.
- `POST /api/signup/admin`: Sign up a new admin with details like name, email, and password.
- `POST /api/signin/user`: Sign in a user with email and password.
- `POST /api/signin/admin`: Sign in an admin with email and password.
- `POST /api/signout`: Sign out the currently authenticated user or admin.

## User Operations

Authenticated users can perform the following operations:

- Place an order: `POST /api/orders` - Create a new order with order details and items.
- View their order history: `GET /api/orders` - Retrieve the order history of the authenticated user.

## Admin Operations

Authenticated admins have additional privileges and can perform the following operations:

- Add a new food item: `POST /api/fooditems` - Create a new food item with details like name, price, etc.
- Update an existing food item: `PUT /api/fooditems/{id}` - Update the details of a specific food item.
- Delete a food item: `DELETE /api/fooditems/{id}` - Delete a specific food item.
- View all food items: `GET /api/fooditems` - Retrieve a list of all available food items.

## Visitor Operations

Visitors who are not authenticated can perform the following operation:

- View all food items: `GET /api/fooditems` - Retrieve a list of all available food items.

## Password Encryption

The service uses MD5 password encryption to store user and admin passwords securely. The encryption code can be found in the `PasswordEncrypter` class.

Please note that this is a simplified example and should be adapted and expanded to fit your specific requirements.

