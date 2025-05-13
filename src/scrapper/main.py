
from pathlib import Path
from urllib.parse import quote
from webdriver_manager.chrome import ChromeDriverManager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import pandas as pd
import time

ROOT = Path(__file__).parents[0]

def main():

    cases = load_txt(ROOT / "cases.txt")
    print(len(cases))

    data = pd.read_csv("./cases_data.csv")
    
    cases_column = data["Case"].to_list()
    skins_column = data["Skin"].to_list()

    driver = create_driver(headless=True)
    driver.delete_all_cookies()

    for case in cases:

        if case not in cases_column:
            elements = get_case_metadata(driver, case )

            if elements:

                cases_column.extend([case]*len(elements))
                skins_column.extend(elements)

    data = pd.DataFrame()
    data["Case"] = cases_column
    data["Skin"] = skins_column

    data["Skin"] = data["Skin"].apply(lambda value: value if "|" in value else "DELETE")
    data = data[~data["Skin"].isin(["DELETE"])]
    data = data.to_csv("./cases_data.csv", index=False)
    print("File saved..")

def get_case_metadata(driver, case: str):
    print("===========================")

    coded_case_name = quote(case)
    driver.get(f"https://steamcommunity.com/market/listings/730/{coded_case_name}" )

    elements_found = driver.find_elements(By.CLASS_NAME, "descriptor")
    
    if not elements_found:
        print(f"Timedout: {case}")
        return []

    print(f"Added: {case}")
    time.sleep(10)
    return [element.text for element in elements_found]

def create_driver(headless: bool):

    options = webdriver.ChromeOptions()
    if headless:
        options.add_argument('headless')

    options.add_argument("--disable-blink-features=AutomationControlled")
    driver = webdriver.Chrome(
            service = Service(ChromeDriverManager().install()),
            options = options
        )

    return driver




def load_txt(path):

    with open(path, "r", encoding="utf-8") as file:
        return file.readlines()

if __name__ == "__main__":
    
    main()
