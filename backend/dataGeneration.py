import random

# generate user data

random_names = ["Sophia", "Liam", "Olivia", "Noah", "Emma", "Jackson", "Ava", "Lucas", 
    "Isabella", "Aiden", "Mia", "Caden", "Amelia", "Elijah", "Harper", 
    "Grayson", "Evelyn", "Mason", "Abigail", "Logan"]

random_road_names = ["Maple Avenue", "Elm Street", "Oak Drive", "Pine Road", "Cedar Lane",
    "Birch Street", "Willow Way", "Sycamore Lane", "Chestnut Street", "Walnut Avenue",
    "Magnolia Drive", "Cypress Road", "Aspen Lane", "Juniper Street", "Poplar Avenue",
    "Spruce Drive", "Hawthorn Lane", "Cherry Street", "Linden Road", "Alder Avenue"]

random_city_names = ["London", "New York", "Paris", "Tokyo", "Sydney",
    "Los Angeles", "Rome", "Berlin", "Moscow", "Singapore"]

random_state_initials = ["VA", "PA", "NY", "RI", "NH", "WV"]

booleans = ["True", "False"]

def generate_users(num_times, filename):
    list_of_users = []
    # userId,farmID,addressLine,city,state,zipcode,consumer,email,salt,password
    for i in range(num_times):
        current_user = "{},{},{},{},{},{},{},{},{},{}"
        # fill in the format
        current_user = current_user.format(random.randint(1, 9999999), random.randint(1, 9999999), str(random.randint(1, 999)) + " " + 
                            random_road_names[random.randint(0, 19)], random_city_names[random.randint(0, 9)], 
                            random_state_initials[random.randint(0, 5)], random.randint(11111, 99999), booleans[random.randint(0, 1)],
                            random_names[random.randint(0, 19)] + "@example.com", random.randint(11111111,999999999), "password")
        list_of_users.append(current_user)
    text_to_write = "\n".join(list_of_users)
    with open(filename, "w") as file:
        file.write(text_to_write)
    
generate_users(5, "sample_users.csv")
