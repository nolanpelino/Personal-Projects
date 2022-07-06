// All valid credit card numbers
const valid1 = [4, 5, 3, 9, 6, 7, 7, 9, 0, 8, 0, 1, 6, 8, 0, 8]
const valid2 = [5, 5, 3, 5, 7, 6, 6, 7, 6, 8, 7, 5, 1, 4, 3, 9]
const valid3 = [3, 7, 1, 6, 1, 2, 0, 1, 9, 9, 8, 5, 2, 3, 6]
const valid4 = [6, 0, 1, 1, 1, 4, 4, 3, 4, 0, 6, 8, 2, 9, 0, 5]
const valid5 = [4, 5, 3, 9, 4, 0, 4, 9, 6, 7, 8, 6, 9, 6, 6, 6]

// All invalid credit card numbers
const invalid1 = [4, 5, 3, 2, 7, 7, 8, 7, 7, 1, 0, 9, 1, 7, 9, 5]
const invalid2 = [5, 7, 9, 5, 5, 9, 3, 3, 9, 2, 1, 3, 4, 6, 4, 3]
const invalid3 = [3, 7, 5, 7, 9, 6, 0, 8, 4, 4, 5, 9, 9, 1, 4]
const invalid4 = [6, 0, 1, 1, 1, 2, 7, 9, 6, 1, 7, 7, 7, 9, 3, 5]
const invalid5 = [5, 3, 8, 2, 0, 1, 9, 7, 7, 2, 8, 8, 3, 8, 5, 4]

// Can be either valid or invalid
const mystery1 = [3, 4, 4, 8, 0, 1, 9, 6, 8, 3, 0, 5, 4, 1, 4]
const mystery2 = [5, 4, 6, 6, 1, 0, 0, 8, 6, 1, 6, 2, 0, 2, 3, 9]
const mystery3 = [6, 0, 1, 1, 3, 7, 7, 0, 2, 0, 9, 6, 2, 6, 5, 6, 2, 0, 3]
const mystery4 = [4, 9, 2, 9, 8, 7, 7, 1, 6, 9, 2, 1, 7, 0, 9, 3]
const mystery5 = [4, 9, 1, 3, 5, 4, 0, 4, 6, 3, 0, 7, 2, 5, 2, 3]

// An array of all the arrays above
const batch = [valid1, valid2, valid3, valid4, valid5, invalid1, invalid2, invalid3, invalid4, invalid5, mystery1, mystery2, mystery3, mystery4, mystery5]



/*
This function will check the credit card number using the Luhn algorithm
*/
function validateCred(ccArr) {
    let currentNum;
    let sum = 0;
    let doubleIt = false;
    for (let i = ccArr.length - 1; i >= 0; i--) {
        currentNum = ccArr[i];
        if (doubleIt) {  // this conditional check helpls multiply every other digit
            currentNum = currentNum * 2;
            doubleIt = false;
            if (currentNum > 9)
                currentNum -= 9;
        } else {
            doubleIt = true;
        }
        sum += currentNum;
    }
    return (sum % 10 == 0);  // If the sum modulo 10 is 0, then the array is valid
}

/*
Function goes through a nested array and returns an array containing the invalid credit cards
*/
function findInvalidCards(allCards) {
    let invArray = [];
    for (let i = 0; i < allCards.length; i++) {
        if (!validateCred(allCards[i])) {
            invArray.push(allCards[i]);
        }
    }
    return invArray;
}

/*
This function returns and array of companies that have sent out bad cards.
The first digit of the card dictates the company.
3	Amex (American Express)
4	Visa
5	Mastercard
6	Discover
*/
function idInvalidCardCompanies(badCards) {
    let firstNum;
    let badCompanies = [];
    for (let i = 0; i < badCards.length; i++) {
        firstNum = badCards[i][0];
        switch (firstNum) {
            case 3:
                if (badCompanies.indexOf("Amex (American Express)") == -1)
                    badCompanies.push("Amex (American Express)");
                break;
            case 4:
                if (badCompanies.indexOf("Visa") == -1)
                    badCompanies.push("Visa");
                break;
            case 5:
                if (badCompanies.indexOf("Mastercard") == -1)
                    badCompanies.push("Mastercard");
                break;
            case 6:
                if (badCompanies.indexOf("Discover") == -1)
                    badCompanies.push("Discover");
                break;
            default:
                console.log("Company not found");
                break;
        }
    }
    return badCompanies;
}