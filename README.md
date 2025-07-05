🛒 E-Commerce Checkout System – Internship Challenge
This project was built as part of the Fawry Quantum Full Stack Internship Challenge 3.
The goal was to design a lightweight, console-based e-commerce system that handles products, cart operations, shipping, 
and customer checkout — all while applying good object-oriented design principles.

💡 Features
- Product Management:
  Supports different types of products:
  
  Some can expire (like Cheese and Biscuits)
  
  Some require shipping and have weight (like TV and Cheese)
  
  Others don't need shipping (like Mobile scratch cards)

- Cart System

  Add items with specific quantities
  
  Prevent adding more than available stock
  
  Block expired products from being added

- Checkout Flow

  Validates cart contents
  
  Calculates subtotal, shipping cost, and total amount
  
  Deducts purchased quantity from stock
  
  Updates customer balance after purchase
  
  Rejects checkout if cart is empty, balance is insufficient, or items are invalid

- Shipping Integration

  Collects all shippable items
  
  Calculates total package weight
  
  Prints a shipment notice and receipt as per spec

