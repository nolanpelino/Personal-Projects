import requests
import json

# Define the base URL for the GroupMe API
base_url = "https://api.groupme.com/v3"

# Define your access token, group ID, and user ID
access_token = ""
group_id = "GROUP_ID"
user_id = "USER_ID"
nickname = "Cooper Vance"

# Define the URL for the groups endpoint
groups_url = f"{base_url}/groups?token={access_token}"

# Send a GET request to the GroupMe API
groups_response = requests.get(groups_url)

# If the request was successful
if groups_response.status_code == 200:
    # Load the response data as JSON
    groups_data = json.loads(groups_response.text)

    # Iterate over the groups
    for group in groups_data['response']:
        # If the group's name is "Rah Rah Ree"
        if group['name'] == 'Rah Rah Ree':
            # Set the group's ID to the group_id variable
            group_id = group['id']
            break
        
# Define the URL for the members endpoint of the specific group
members_url = f"{base_url}/groups/{group_id}?token={access_token}"

# Send a GET request to the GroupMe API
members_response = requests.get(members_url)

# If the request was successful
if members_response.status_code == 200:
    # Load the response data as JSON
    members_data = json.loads(members_response.text)

    # Iterate over the members
    for member in members_data['response']['members']:
        # If the member's name is "Brendan Doherty"
        if member['nickname'] == nickname:
            # Set the member's ID to the user_id variable
            user_id = member['user_id']
            break

# Initialize a counter for the messages
message_count = 0

# Define the URL for the messages endpoint
url = f"{base_url}/groups/{group_id}/messages?token={access_token}"

while True:
    # Send a GET request to the GroupMe API
    response = requests.get(url)

    # If the request was successful
    if response.status_code == 200:
        # Load the response data as JSON
        data = json.loads(response.text)

        # For each message in the response data
        for message in data['response']['messages']:
            # If the message was sent by the user
            if message['user_id'] == user_id:
                # Increment the message counter
                message_count += 1

        # If there are more messages to fetch
        if 'before_id' in data['response']:
            # Update the URL to fetch the next batch of messages
            url = f"{base_url}/groups/{group_id}/messages?token={access_token}&before_id={data['response']['before_id']}"
        else:
            # If there are no more messages to fetch, break the loop
            break
    else:
        # If the request was not successful, print the status code and break the loop
        print(f"Request failed with status code {response.status_code}")
        break

# Print the total number of messages sent by the user
print(f"User {nickname} has sent {message_count} messages in group {'Rah Rah Ree'}.")